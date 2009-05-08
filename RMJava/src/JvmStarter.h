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
	std::string *jarFile;


public:


	JvmStarter() {
	}

	void start(std::string *jarFile);
	void startJVM();
	void replaceChar(std::string &input, const char* inputChar, const char* replaceChar);
	std::string getMainClass(JNIEnv *jniEnv, string *jarFileName);

	virtual void run() {

		startJVM();
		mainClass = getMainClass(jniEnv, jarFile);
		replaceChar(mainClass, ".", "/");

		jvm -> AttachCurrentThread((void**)&jniEnv, NULL);

		char CurrentPath[1024];
		cout << getcwd(CurrentPath, 1024) << endl;

		jclass mainClazz = 0;
		jmethodID mainID;
		const char *cMainClass = mainClass.data();

		mainClazz = jniEnv -> FindClass(cMainClass);

		if (mainClazz == 0) {
			cout << "Can't get class " << "'" << cMainClass << "'" << endl;
			exit(-1);
		}
		cout << "finished startMain" << endl;
		mainID = jniEnv -> GetStaticMethodID(mainClazz, "main", "([Ljava/lang/String;)V");

		jclass cls = jniEnv -> FindClass("java/lang/String");
		jobject ary = jniEnv -> NewObjectArray(0, cls, 0);

		jniEnv -> CallStaticVoidMethod(mainClazz, mainID, ary);

	}
	virtual ~JvmStarter() {

	}
};

void* threadExecutor(void* param) {
	cout << "threadExecutor starting" << endl;
	JvmStarter* starter = (JvmStarter*) param;

	starter -> run();
	return 0;
}

void JvmStarter::start(std::string *jarFile) {

	this -> jarFile = jarFile;
	int threadId;
	//startJVM();

	threadId = pthread_create(&thread, 0, threadExecutor, this);
	pthread_join(thread, NULL);
	jvm -> DestroyJavaVM();
}

void JvmStarter::startJVM() {

	typedef int createVM(JavaVM **, void **, void *);

	JavaVMOption options[2];
	JavaVMInitArgs vm_args;

	int result;

	char path[1024];
	sprintf(path,"%s%s","-Djava.class.path=",jarFile -> data());
	cout << "Property java.class.path is: " << jarFile -> data();



	options[0].optionString = "-Djava.compiler=NONE";
	options[1].optionString = path;
	//options[2].optionString = "-verbose:jni";
	//options[2].optionString = "-verbose:jni";

	vm_args.version = JNI_VERSION_1_4;
	vm_args.options = options;
	vm_args.nOptions = 2;
	vm_args.ignoreUnrecognized = JNI_TRUE;

	cout << "Starting JVM with library: " << PATHS_TO_JVM_LIB << "\n";

	void *libVM = dlopen(PATHS_TO_JVM_LIB, RTLD_LAZY);

	const char* dlsym_error = dlerror();

	if (dlsym_error) {
		cerr << "Cannot load symbol: " << dlsym_error << '\n';
	}

	createVM* libjvm_create = NULL;

	libjvm_create = (createVM*) dlsym(libVM, DYNAMIC_LIB_JVMCREATE);

	dlsym_error = dlerror();
	if (dlsym_error) {
		cerr << "Cannot load symbol create: " << dlsym_error << '\n';
		exit(-1);
	}

	if (libjvm_create == 0) {
		cout << "Error starting jvm. Exiting ...";
		exit(-1);
	}

	result = (*libjvm_create)(&jvm, (void**) &jniEnv, &vm_args);

	if (result == JNI_ERR) {
		printf("Error invoking the JVM");
		exit(-1);
	}

	if (jniEnv->ExceptionCheck()) {
		jniEnv->ExceptionDescribe();
	}

}

string JvmStarter::getMainClass(JNIEnv *jniEnv, std::string *jarFileName) {
#define MAIN_CLASS "Main-Class"

	static JavaVM *g_jVM = NULL;

	jniEnv -> GetJavaVM(&g_jVM);

	cout << "getMainClass() starting" << endl;

	jmethodID jMethodId;
	jobject jManifest, jAttr, jJar;
	jclass jClass;
	jstring jStr, jMainClass;

	// Loading jarFile
	jClass = jniEnv -> FindClass("java/util/jar/JarFile");
	if (jClass == 0) {
		cerr << "jClass == 0" << endl;
	}

	jMethodId = jniEnv -> GetMethodID(jClass, "<init>", "(Ljava/lang/String;)V");
	jStr = jniEnv -> NewStringUTF(jarFileName -> data());
	jJar = jniEnv -> NewObject(jClass, jMethodId, jStr);

	if (jJar == 0) {
		cout << "Can't load JarFile " << jarFileName << "! Exiting ... \n";
		exit(-1);
	}

	// Getting manifest
	jMethodId = jniEnv -> GetMethodID(jClass, "getManifest", "()Ljava/util/jar/Manifest;");
	jManifest = jniEnv -> CallObjectMethod(jJar, jMethodId);

	jMethodId = jniEnv -> GetMethodID(jniEnv -> GetObjectClass(jManifest), "getMainAttributes",
			"()Ljava/util/jar/Attributes;");
	jAttr = jniEnv -> CallObjectMethod(jManifest, jMethodId);

	jMethodId = jniEnv -> GetMethodID(jniEnv -> GetObjectClass(jAttr), "getValue",
			"(Ljava/lang/String;)Ljava/lang/String;");
	jStr = jniEnv -> NewStringUTF(MAIN_CLASS);
	jMainClass = (jstring) jniEnv -> CallObjectMethod(jAttr, jMethodId, jStr);

	const char* mainClass = jniEnv -> GetStringUTFChars(jMainClass, 0);

	return string(mainClass);

}

void JvmStarter::replaceChar(string &input, const char* c1, const char* c2) {
	string::size_type pos = 0;
	string::size_type amount = strlen(c1);

	// npos = length of string
	while ((pos = input.find(c1, pos + 1)) != string::npos) {
		cout << pos << ",";
		input.replace(pos, amount, c2);
	}
}

#endif /* JVMSTARTER_H_ */
