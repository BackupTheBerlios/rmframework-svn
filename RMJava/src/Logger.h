/*
 *  Logger.h
 *  FMJava.XC23
 *
 *  Created by Heiko Kundlacz on 03.06.09.
 *  Copyright 2009 __MyCompanyName__. All rights reserved.
 *
 */
 
#include <iostream>
#include <fstream>

#ifndef LOGGER_H_
#define LOGGER_H_
 
class LogHelper {

private:
	bool debug;
	string fileName;
	
public: 
		Logger(bool debug) {
			this -> debug = debug;
			fileName = "/tmp/debug.log";
		}
		
		Logger(bool* debug, string fileName) {
			this -> debug = debug;
			this -> fileName = fileName;
		}
	
		void info(string* message);
	
};

void Logger::info(string* message) {

	FILE *pfile; 
	fprintf (pfile, "Name %s \n", message -> data());

	if (debug) {
		ostream *oriStream;
		ofstream fileStream;
		fileStream.open(fileName.data());
		oriStream = cin.tie(&fileStream);
		*cin.tie() << message << endl;
		*cin.tie(oriStream);
		fileStream.close();
	}
	
	*cin.tie() << message -> data() << endl;
}
 
#endif // LOGGER_H

