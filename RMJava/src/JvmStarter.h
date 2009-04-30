/*
 * JvmStarter.h
 *
 *  Created on: Apr 29, 2009
 *  Author: heikok
 */

#include <iostream>
#include <jni.h>
#include <string>
#include <pthread.h>

#ifndef JVMSTARTER_H_
#define JVMSTARTER_H_

class JvmStarter {

private:
	JNIEnv* jniEnv;
	pthread_t thread;
	string mainClass;

public:


	JvmStarter() {
	}

	void start(JNIEnv* env, std::string mainClass);

	virtual void run() {

		JavaVM *vm;
		jniEnv -> GetJavaVM(&vm);

		vm -> AttachCurrentThread((void**)&jniEnv, NULL);

		cout << "running thread" << endl;

		char CurrentPath[1024];
		cout << getcwd(CurrentPath, 1024) << endl;

		jclass mainClazz = 0;
		jmethodID mainID;
		const char *cMainClass = mainClass.data();

		cout << cMainClass << endl;
		cout << "jniEnv: " << jniEnv << endl;

		mainClazz = jniEnv -> FindClass(cMainClass);

		cout << cMainClass << endl;
		//mainClazz = this -> jniEnv -> FindClass("net/form105/rm/base/Agent");
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
	virtual ~JvmStarter() {

	}
};

void* threadExecutor(void* param) {
	cout << "threadExecutor starting" << endl;
	JvmStarter* starter = (JvmStarter*) param;
	starter -> run();
	return 0;
}

void JvmStarter::start(JNIEnv* env, std::string mainClass) {
	cout << "executing start" << endl;
	this -> jniEnv = env;
	this -> mainClass = mainClass;
	int threadId;
	threadId = pthread_create(&thread, 0, threadExecutor, this);
	pthread_join(thread, NULL);
}

#endif /* JVMSTARTER_H_ */
