/*
 * CPP.cpp
 *
 *  Created on: Apr 20, 2009
 *  Author: heiko
 */

#include <iostream>
#include <jni.h>
#include "JavaAgent.h"
#include <pthread.h>

using namespace std;

void jnicall(void);

int main(int argc, char **argv) {

	JavaAgent agent;
	JNIEnv *jniEnv;
	char jarPath[] = "RMBase-0.1.jar";
	jniEnv = agent.startJVM(jarPath);

	string mainClass = agent.getMainClass(jniEnv, jarPath);
	agent.replaceChar(mainClass, ".", "/");
	cout << mainClass << endl;


	agent.startMain(jniEnv, mainClass);

	if (jniEnv->ExceptionCheck()) {
		cout << "got error";
		jniEnv->ExceptionDescribe();
	}


}

void* jnicall(void *arg) {
return 0;
}

