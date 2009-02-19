/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.form105.rm.base.db.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.db.AbstractDBEntity;

import org.apache.log4j.Logger;
import org.junit.Test;


public class DBHandler {
	
	public static Logger logger = Logger.getLogger(DBHandler.class);

	private Map dbEntityMap = new HashMap();

	@Test
	public void initialize() {
		for (String decl : getEntityDeclarationList()) {
			try {
				Class clazz = Class.forName(decl);
				if (AbstractDBEntity.class.isAssignableFrom(clazz)) {
					logger.info("is instance");
				} else {
					//TODO: create a rm exception
					logger.error("A class has been provided which doesn't extends a dbEntity");
				}
			} catch (ClassNotFoundException e) {
				logger.error(e,e);
				
			}
		}
		
	}
	
	public List<String> getEntityDeclarationList() {
		List<String> decList = new ArrayList<String>();
		decList.add("com.form105.rm.base.db.jdbc.ResourceDbMapper");
		return decList;
	}

	

}
