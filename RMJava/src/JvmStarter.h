/*
 * JvmStarter.h
 *
 *  Created on: Apr 29, 2009
 *  Author: heikok
 */

#include <iostream>
#include <string>
#include <pthread.h>
#include <dlfcn.h>
#include "JvmAttributes.h"

#ifndef JVMSTARTER_H_
#define JVMSTARTER_H_

# if defined( __linux__ )
#	include <jni.h>
#	define PATHS_TO_JVM_LIB "/usr/lib/jvm/java-6-sun/jre/lib/i386/client/libjvm.so"
# 	define DYNAMIC_LIB_JVMCREATE "JNI_CreateJavaVM"
# endif

# ifdef __APPLE__
#	include <JavaVM/jni.h>
#	define PATHS_TO_JVM_LIB "/System/Library/Frameworks/JavaVM.framework/Versions/1.5.0/Libraries/libjvm.dylib"
# 	define DYNAMIC_LIB_JVMCREATE "JNI_CreateJavaVM_Impl"
# endif

using namespace std;

class JvmStarter {

private:
	JNIEnv* jniEnv;
	JavaVM* jvm;
	pthread_t thread;
	std::string mainClass;
	JvmAttributes* attributes;

public:

	JvmStarter(JvmAttributes* attributes) {
		this -> attributes = attributes;
	}

	void start();
	void startJVM();
	void startMain();
	void replaceChar(std::string &input, const char* inputChar, const char* replaceChar);

	std::string getMainClass(JNIEnv *jniEnv, string *jarFileName);
	void sendLogEntry(unsigned short* logCategory, long sizeCategory, unsigned short* logMessage, long sizeMessage);
	void destroyVM(void);
	bool jvmInitialized(void);
	JavaVM* getJavaVM(void);

	void stopServerService();

	virtual void run() {

		startJVM();
		startMain();

	}
	virtual ~JvmStarter() {

	}
};

void* threadExecutor(void* param) {
	JvmStarter* starter = (JvmStarter*) param;

	starter -> run();
	return 0;
}

void JvmStarter::startMain() {
	std::string jarFile = this -> attributes -> getJarFile();
	mainClass = getMainClass(jniEnv, &jarFile);
	replaceChar(mainClass, ".", "/");

	jclass mainClazz = 0;
	jmethodID mainID;
	const char *cMainClass = mainClass.data();

	mainClazz = jniEnv -> FindClass(cMainClass);

	if (mainClazz == 0) {
		cout << "Can't get class " << "'" << cMainClass << "'" << endl;
	}

	mainID = jniEnv -> GetStaticMethodID(mainClazz, "main", "([Ljava/lang/String;)V");

	jclass cls = jniEnv -> FindClass("java/lang/String");
	jobject ary = jniEnv -> NewObjectArray(0, cls, 0);

	jniEnv -> CallStaticVoidMethod(mainClazz, mainID, ary);

	if (jniEnv->ExceptionCheck()) {
		jniEnv->ExceptionDescribe();
	}

}

void JvmStarter::start() {
	int threadId;
	threadId = pthread_create(&thread, 0, threadExecutor, this);
}

void JvmStarter::startJVM() {

	typedef int createVM(JavaVM **, void **, void *);

	JavaVMOption options[4];
	JavaVMInitArgs vm_args;

	int result;

	char homeDir[1024];
	sprintf(homeDir, "%s%s", "-Drmbase.home.dir=", this -> attributes -> getHomeDir().data());
	cout << "Property rmbase.home.dir is: " << this -> attributes -> getHomeDir().data() << "\n";

	char path[1024];
	sprintf(path, "%s%s", "-Djava.class.path=", this -> attributes -> getJarFile().data());
	cout << "Property java.class.path is: " << this -> attributes -> getJarFile().data() << "\n";

	options[0].optionString = "-Djava.compiler=NONE";
	options[1].optionString = "-Dcom.sun.management.jmxremote";
	options[2].optionString = path;
	options[3].optionString = homeDir;

	vm_args.version = JNI_VERSION_1_4;
	vm_args.options = options;
	vm_args.nOptions = 4;
	vm_args.ignoreUnrecognized = JNI_TRUE;

	cout << "Starting JVM with library: " << PATHS_TO_JVM_LIB << "\n";

	void *libVM = dlopen(PATHS_TO_JVM_LIB, RTLD_LAZY);

	const char* dlsym_error = dlerror();

	if (dlsym_error) {
		cerr << "Cannot load symbol: " << dlsym_error << '\n';
	}

	createVM* libjvm_create = NULL;

	libjvm_create = (createVM*) dlsym(libVM, DYNAMIC_LIB_JVMCREATE);

	if (libjvm_create == 0) {
		cerr << "libjvm not loaded" << endl;
	}

	dlsym_error = dlerror();
	if (dlsym_error) {
		cerr << "Cannot load symbol create: " << dlsym_error << '\n';
	}

	if (libjvm_create == 0) {
		cerr << "Error starting jvm. Exiting ...";
	}

	result = (*libjvm_create)(&jvm, (void**) &jniEnv, &vm_args);

	cout << "started jvm with result: " << result << endl;

	if (result == JNI_ERR) {
		cerr << "Error invoking the JVM" << endl;
	}

	if (jniEnv->ExceptionCheck()) {
		jniEnv->ExceptionDescribe();
	}
}

string JvmStarter::getMainClass(JNIEnv *jniEnv, std::string* jarFileName) {
#define MAIN_CLASS "Main-Class"

	jmethodID jMethodId;
	jobject jManifest, jAttr, jJar;
	jclass jClass;
	jstring jStr, jMainClass;

	// Loading jarFile
	jClass = jniEnv -> FindClass("java/util/jar/JarFile");
	if (jClass == 0) {
		cerr << "Error: Can't load Class java/util/jar/JarFile" << endl;
	}

	jMethodId = jniEnv -> GetMethodID(jClass, "<init>", "(Ljava/lang/String;)V");
	if (jMethodId == 0) {
		cerr << "Error: Can't find constructor for java/util/jar/JarFile(String) " << endl;
	}
	jStr = jniEnv -> NewStringUTF(jarFileName -> data());
	jJar = jniEnv -> NewObject(jClass, jMethodId, jStr);

	if (jniEnv->ExceptionCheck()) {
		jniEnv->ExceptionDescribe();
		cerr << "Error: Can't load JarFile " << jarFileName -> data() << endl;
	}

	// Getting manifest
	jMethodId = jniEnv -> GetMethodID(jClass, "getManifest", "()Ljava/util/jar/Manifest;");
	if (jMethodId == 0) {
		cout << "Error: Can't find method getManifest in java.util.jar.Manifest" << endl;
	}
	jManifest = jniEnv -> CallObjectMethod(jJar, jMethodId);

	jMethodId = jniEnv -> GetMethodID(jniEnv -> GetObjectClass(jManifest), "getMainAttributes","()Ljava/util/jar/Attributes;");
	jAttr = jniEnv -> CallObjectMethod(jManifest, jMethodId);

	if (jniEnv->ExceptionCheck()) {
		jniEnv->ExceptionDescribe();
		cout << "Error: Can't load JarFile " << jarFileName -> data() << endl;
	}

	jMethodId = jniEnv -> GetMethodID(jniEnv -> GetObjectClass(jAttr), "getValue", "(Ljava/lang/String;)Ljava/lang/String;");
	jStr = jniEnv -> NewStringUTF(MAIN_CLASS);
	jMainClass = (jstring) jniEnv -> CallObjectMethod(jAttr, jMethodId, jStr);
	if (jMainClass == 0) {
		cout << "Error: Can't find attribute MainClass in the manifest." << endl;
	}

	if (jniEnv->ExceptionCheck()) {
		jniEnv->ExceptionDescribe();
		cout << "Error: Can't load JarFile " << jarFileName -> data() << endl;
	}

	const char* mainClass = jniEnv -> GetStringUTFChars(jMainClass, 0);
	return string(mainClass);

}

void JvmStarter::replaceChar(string &input, const char* c1, const char* c2) {
	string::size_type pos = 0;
	string::size_type amount = strlen(c1);

	// npos = length of string
	while ((pos = input.find(c1, pos + 1)) != string::npos) {
		input.replace(pos, amount, c2);
	}
}

void JvmStarter::sendLogEntry(unsigned short* logCategory, long sizeCategory, unsigned short* logMessage, long sizeMessage) {

	jint result;
	result = jvm -> AttachCurrentThread((void**) &jniEnv, NULL);

	if (result > 0) {
		cerr << "Error: Attaching current thread by JNI." << endl;
	}

	jclass serviceClass = jniEnv -> FindClass("net/form105/rm/server/service/log/StandardLogService");
	if (serviceClass == 0) {
		cerr << "Can't load class StandardLogService." << endl;
	}

	jclass argumentClass = jniEnv -> FindClass("net/form105/rm/server/service/log/StandardLogService$ServiceArgument");
	if (argumentClass == 0) {
		cerr << "Can't load Argument class from StandardLogService." << endl;
	}

	jmethodID jMethodId = jniEnv -> GetMethodID(serviceClass, "<init>", "()V");
	if (jMethodId == 0) {
		cerr << "Can't load class StandardLogService." << endl;
	}

	jobject service = jniEnv -> NewObject(serviceClass, jMethodId);
	if (service == 0) {
		cerr << "Can't instantiate service object" << endl;
	}

	jmethodID argumentMethod = jniEnv -> GetMethodID(serviceClass, "getArgument", "()Lnet/form105/rm/server/service/log/StandardLogService$ServiceArgument;");
	if (argumentMethod == 0) {
		cerr << "Can't get method id from getArgument()" << endl;
	}
	jobject argumentObject = jniEnv -> CallObjectMethod(service, argumentMethod);

	jstring jCategory = jniEnv -> NewString((const jchar*) logCategory, sizeCategory);
	jstring jMessage = jniEnv -> NewString((const jchar*) logMessage, sizeMessage);

	jfieldID categoryFieldId = jniEnv -> GetFieldID(argumentClass, "category", "Ljava/lang/String;");
	if (categoryFieldId == 0) {
		cerr << "Failed to find field category." << endl;
	}

	jfieldID messageFieldId = jniEnv -> GetFieldID(argumentClass, "logMessage", "Ljava/lang/String;");
	if (messageFieldId == 0) {
		cerr << "Failed to find field logMessage." << endl;
	}

	jniEnv -> SetObjectField(argumentObject, categoryFieldId, jCategory);
	jniEnv -> SetObjectField(argumentObject, messageFieldId, jMessage);

	// get method for execution

	jmethodID executeMethod = jniEnv -> GetMethodID(serviceClass, "execute", "()V");
	if (executeMethod == 0) {
		cerr << "Error: Can't find execute() in service class." << endl;
	}

	jniEnv -> CallObjectMethod(service, executeMethod);
	if (jniEnv->ExceptionCheck()) {
		jniEnv->ExceptionDescribe();
	}

	result = jvm -> DetachCurrentThread();

}

void JvmStarter::stopServerService() {
	jint result;
	result = jvm -> AttachCurrentThread((void**) &jniEnv, NULL);

	if (result > 0) {
		cerr << "Error: Attaching current thread by JNI." << endl;
	}

	jclass serviceClass = jniEnv -> FindClass("net/form105/rm/server/service/StopServerService");
	if (serviceClass == 0) {
		cerr << "Can't load class StandardLogService." << endl;
	}

	jmethodID jMethodId = jniEnv -> GetMethodID(serviceClass, "<init>", "()V");
	if (jMethodId == 0) {
		cerr << "Can't load class StandardLogService." << endl;
	}

	jobject service = jniEnv -> NewObject(serviceClass, jMethodId);
	if (service == 0) {
		cerr << "Can't instantiate service object" << endl;
	}


	// get method for execution

	jmethodID executeMethod = jniEnv -> GetMethodID(serviceClass, "execute", "()V");
	if (executeMethod == 0) {
		cerr << "Error: Can't find execute() in service class." << endl;
	}

	jniEnv -> CallObjectMethod(service, executeMethod);
	if (jniEnv->ExceptionCheck()) {
		jniEnv->ExceptionDescribe();
	}

	result = jvm -> DetachCurrentThread();
}

void JvmStarter::destroyVM() {
	jint result;
	result = jvm -> AttachCurrentThread((void**) &jniEnv, NULL);
	stopServerService();
	result = jvm -> DetachCurrentThread();
	//jvm -> DestroyJavaVM();

}

bool JvmStarter::jvmInitialized() {
	if (jvm == 0) return false;
	return true;
}

JavaVM* JvmStarter::getJavaVM() {
	return jvm;
}



#endif /* JVMSTARTER_H_ */
