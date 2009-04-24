/*
 * CPP.cpp
 *
 *  Created on: Apr 20, 2009
 *  Author: heiko
 */

#include <iostream>
#include <jni.h>
#include "JavaAgent.h"

int main(int argc, char **argv) {

	JavaAgent agent;
	JNIEnv *jniEnv;
	char jarPath[] = "./RMBase-0.1.jar";
	jniEnv = agent.startJVM(jarPath);

	string mainClass = agent.getMainClass(jniEnv, jarPath);
	agent.replaceChar(mainClass, ".", "/");
	cout << mainClass << endl;
	agent.startMain(jniEnv, mainClass);

}

