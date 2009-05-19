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

using namespace std;

void jnicall(void);

int main(int argc, char **argv) {

	//const char jarPath[] = "RMBase-0.1.jar";

	const char jarPath[] = "/Applications/FileMaker Pro 10 Advanced/Extensions/FMPluginDebug.fmplugin/RMBase-0.1.jar";

	JvmStarter starter;
	starter.start(new string(jarPath));

}

