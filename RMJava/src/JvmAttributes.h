/*
 *  JvmAttributes.h
 *  FMJava.XC23
 *
 *  Created by Heiko Kundlacz on 12.05.09.
 *  Copyright 2009 EPAC Technologies GmbH. All rights reserved.
 *
 */

#ifndef JVMATTRIBUTES_H_
#define JVMATTRIBUTES_H_

#include <string>

using namespace std;

class JvmAttributes {

	private:
		std::string *jarFile;
		std::string *homeDir;

	public:

	JvmAttributes() {}

	std::string getJarFile();
	std::string getHomeDir();
	void setJarFile(std::string* jarFile);
	void setHomeDir(std::string* homeDir);

	virtual ~JvmAttributes() {

	}


};

std::string JvmAttributes::getJarFile() {
	return *jarFile;
}

std::string JvmAttributes::getHomeDir() {
	return *homeDir;
}

void JvmAttributes::setHomeDir(std::string* homeDir) {
	this -> homeDir = homeDir;
}

void JvmAttributes::setJarFile(std::string* jarFile) {
	this -> jarFile = jarFile;
}

#endif /* JVMATTRIBUTES_H_ */
