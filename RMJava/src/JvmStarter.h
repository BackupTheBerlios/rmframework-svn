/*
 * JvmStarter.h
 *
 *  Created on: Apr 29, 2009
 *      Author: heikok
 */



#include <jni.h>

#ifndef JVMSTARTER_H_
#define JVMSTARTER_H_

class JvmStarter {
private:
	JNIEnv jniEnv;

public:

	JvmStarter();
	JvmStarter(JNIEnv* env);

	virtual ~JvmStarter();


};

#endif /* JVMSTARTER_H_ */
