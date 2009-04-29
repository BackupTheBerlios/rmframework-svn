/*
 * JavaAgent.h
 *
 *  Created on: Apr 9, 2009
 *      Author: heiko
 */

#include <iostream>
#include <string>
#include <jni.h>

using namespace std;

#ifndef JAVAAGENT_H_
#define JAVAAGENT_H_



class JavaAgent {
public:
	JavaAgent();

	string getMainClass(JNIEnv* jniEnv, char* jarFile);
	bool checkCLParameters(int argc, char** env);
	JNIEnv* startJVM(char* jarPath);
	void replaceChar(string &input, char* c1, char* c2);
	void startMain(JNIEnv* jniEnv, string mainClass);
	void start();

	virtual ~JavaAgent();
};

#endif /* JVMAGENT_H_ */




