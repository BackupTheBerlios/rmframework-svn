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
#include <string>

using namespace std;

class LogHelper {

public:
	static LogHelper* Instance();
	void info(bool debug, std::string message);


protected:
	LogHelper() {};
	LogHelper(const LogHelper&) {};
	LogHelper& operator=(const LogHelper&) {};
	static string getCurrentTime(void);

private:
	static LogHelper* _instance;
	static string _fileName;

};

LogHelper* LogHelper::_instance = 0;
string LogHelper::_fileName = string("/tmp/debug.log");

LogHelper* LogHelper::Instance() {
	if (_instance == 0) {
		_instance = new LogHelper;
	}
	return _instance;
}


/*
* Logs a string to a file if we are in debug mode.
*/

void LogHelper::info(bool debug, std::string message) {
	if (debug) {
		ostream *oriStream;
		ofstream fileStream;
		fileStream.open(_fileName.data(), ios::app); // ios::app -> appending to the end
		oriStream = cin.tie(&fileStream);
		*cin.tie() << getCurrentTime() << ": " << message << endl;
		*cin.tie(oriStream);
		fileStream.close();
	}

	*cin.tie() << getCurrentTime() << ": " << message.data() << endl;
}

/*
* Get the current time in a human readable format
*/
string LogHelper::getCurrentTime(void) {
	time_t rawtime;
	struct tm * timeinfo;
	time ( &rawtime );
	timeinfo = localtime ( &rawtime );
	string sTime(asctime(timeinfo));
	int length = sTime.length();
	// delete the CR from the end of the string
	sTime.resize(length - 1);
	return sTime;
}





