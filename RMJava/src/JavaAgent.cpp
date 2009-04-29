/*
 * JavaAgent.cpp
 *
 *  Created on: Apr 9, 2009
 *      Author: heiko
 */

#include <string>
#include <jni.h>
#include "JavaAgent.h"
#include <fstream>
#include <stdlib.h>
#include <dlfcn.h>
#include <pthread.h>

# if defined( __linux__ )
#	define PATHS_TO_JVM_LIB "/usr/lib/jvm/java-6-sun/jre/lib/i386/client/libjvm.so"
# 	define DYNAMIC_LIB_JVMCREATE "JNI_CreateJavaVM"
# endif

# ifdef __APPLE__
#	define PATHS_TO_JVM_LIB "/System/Library/Frameworks/JavaVM.framework/Versions/1.5.0/Libraries/libjvm.dylib"
# 	define DYNAMIC_LIB_JVMCREATE "JNI_CreateJavaVM_Impl"
# endif

using namespace std;

JavaAgent::JavaAgent() {

}

JavaAgent::~JavaAgent() {

}

bool JavaAgent::checkCLParameters(int argc, char **env) {
	bool isJar = false;

	if (strcmp(env[1], "-jar") == 0) {
		cout << "parameter 1 is -jar" << "\n";
		isJar = true;
	}

	if ((argc = 3) && strlen(env[argc - 2]) > 0) {
		cout << "parameter 3: " << env[2] << "\n";
		if (isJar)
			return true;
	}

	return false;
}

string JavaAgent::getMainClass(JNIEnv *jniEnv, char *jarFileName) {
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
	jStr = jniEnv -> NewStringUTF(jarFileName);
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



/**
 * The mainClass is required with / path separator
 */
void JavaAgent::startMain(JNIEnv* jniEnv, string mainClass) {

	char CurrentPath[1024];
	cout << getcwd(CurrentPath, 1024) << endl;

	jclass mainClazz = 0;
	jmethodID mainID;
	const char *cMainClass = mainClass.data();

	//mainClazz = jniEnv -> FindClass(cMainClass);
	mainClazz = jniEnv -> FindClass("net/form105/rm/base/Agent");
	if (mainClazz == 0) {
		cout << "Can't get class " << "'" << cMainClass << "'" << endl;
	}
	cout << "finished startMain" << endl;
	mainID = jniEnv -> GetStaticMethodID(mainClazz, "main", "([Ljava/lang/String;)V");

	cout << "got main id" << endl;

	jclass cls = jniEnv -> FindClass("java/lang/String");
	jobject ary = jniEnv -> NewObjectArray(0, cls, 0);

	jniEnv -> CallStaticVoidMethod(mainClazz, mainID, ary);

}

JNIEnv* JavaAgent::startJVM(char *jarPath) {

	typedef int createVM(JavaVM **, void **, void *);

	cout << "jarPath:" << jarPath << endl;

	JavaVM *jvm;
	JNIEnv *jniEnv;

	JavaVMOption options[2];
	JavaVMInitArgs vm_args;

	int result;

	options[0].optionString = "-Djava.compiler=NONE";
	options[1].optionString = "-Djava.class.path=RMBase-0.1.jar";
	//options[2].optionString = "-verbose:jni";
	//options[2].optionString = "-verbose:jni";

	vm_args.version = JNI_VERSION_1_4;
	vm_args.options = options;
	vm_args.nOptions = 2;
	vm_args.ignoreUnrecognized = JNI_TRUE;

	cout << "Starting JVM with library: " << PATHS_TO_JVM_LIB << "\n";

	void *libVM = dlopen(PATHS_TO_JVM_LIB, RTLD_LAZY);
	cout << "Starting JVM+" << libVM << endl;
	const char* dlsym_error = dlerror();

	if (dlsym_error) {
		cerr << "Cannot load symbol: " << dlsym_error << '\n';
	}

	createVM* libjvm_create = NULL;

	libjvm_create = (createVM*) dlsym(libVM, DYNAMIC_LIB_JVMCREATE);

	dlsym_error = dlerror();
	if (dlsym_error) {
		cerr << "Cannot load symbol create: " << dlsym_error << '\n';
	}

	if (libjvm_create == 0) {
		cout << "Error starting jvm. Exiting ...";
		exit(-1);
	}

	cout << "Started ..." << "\n";

	result = (*libjvm_create)(&jvm, (void**) &jniEnv, &vm_args);

	if (result == JNI_ERR) {
		printf("Error invoking the JVM");
		exit(-1);
	}

	if (jniEnv->ExceptionCheck()) {
		cout << "got error";
		jniEnv->ExceptionDescribe();
	}

	return jniEnv;

}

void JavaAgent::start() {
	pthread_t thread;
	int thread_id;
	thread_id = pthread_create(&thread, 0, executor, 0);
}

void JavaAgent::replaceChar(string &input, char* c1, char* c2) {
	string::size_type pos = 0;
	string::size_type amount = strlen(c1);

	// npos = length of string
	while ((pos = input.find(c1, pos + 1)) != string::npos) {
		cout << pos << ",";
		input.replace(pos, amount, c2);
	}
}

