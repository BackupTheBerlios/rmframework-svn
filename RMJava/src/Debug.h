/*
 *  Debug.h
 *  FMJava.XC23
 *
 *  Created by Heiko Kundlacz on 03.06.09.
 *  Copyright 2009 EPAC Technologies GmbH. All rights reserved.
 *
 */

#ifndef DEBUG_H_
#define DEBUG_H_
class Debug {
 
private:
	static bool MODE;
	
public:
	Debug(bool debug);
	static bool isDebug(void);
};

Debug::Debug(bool debug) {
	this -> MODE = debug;
}

bool Debug::isDebug() {
	return MODE;
}
#endif // DEBUG_H_

