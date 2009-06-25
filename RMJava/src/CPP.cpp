/*
 * CPP.cpp
 *
 *  Created on: Apr 20, 2009
 *  Author: heiko
 */

#include <iostream>
#include <jni.h>
#include <pthread.h>
#include "JvmStarter.h"
#include "LogHelper.h"

using namespace std;

void jnicall(void);

int main(int argc, char **argv) {



	//const char jarPath[] = "RMBase-0.1.jar";

	//const char jarPath[] = "/Applications/FileMaker Pro 10 Advanced/Extensions/FMPluginDebug.fmplugin/RMBase-0.1.jar";

	LogHelper *logger = LogHelper::Instance();
	logger -> info(true, string("this is my log message"));

	JvmAttributes jvmAttributes;
	jvmAttributes.setHomeDir(new string("/Applications/FileMaker Pro 10 Advanced/Extensions/FMJavaDebug.fmplugin"));
	jvmAttributes.setJarFile(new string(
			"/Applications/FileMaker Pro 10 Advanced/Extensions/FMJavaDebug.fmplugin/RMBase-0.1.jar"));

	JvmStarter starter(&jvmAttributes);
	starter.startJVM();
	starter.startMain();
	//starter.stopServerService();
	//starter.destroyVM();



	JavaVM* jvm;

	cout << jvm << endl;

	jsize* size;
	jint result;
	result = JNI_GetCreatedJavaVMs(&jvm, 1, size);

	JNIEnv *env;

	cout << *size << endl;

	//result = javaVM -> GetEnv((void**) &env, JNI_VERSION_1_2);










	cout << "result of getCreateJavaVMs: " << result << endl;

	cout << "size of jvms: " << *size << endl;
	if (*size == 1) {
		cout << "found javavm" << endl;
	}


	//starter.sendLogEntry(new string("fmorder"), new string("sample log entry"));

	//jvmStarter -> startJVM();
	//jvmStarter -> startMain();

}

