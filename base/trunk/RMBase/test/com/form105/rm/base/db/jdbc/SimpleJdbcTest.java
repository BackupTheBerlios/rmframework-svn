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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SimpleJdbcTest {
	
	public static Logger logger = Logger.getLogger(SimpleJdbcTest.class);
	
	@Test
	public void executeInsert() {
		
		/*ComboPooledDataSource defaultDataSource = new ComboPooledDataSource();
		try {
			defaultDataSource.setDriverClass("com.ddtek.jdbc.sequelink.SequeLinkDriver");
		} catch (PropertyVetoException e) {
			logger.error(e, e);
		}
		defaultDataSource.setJdbcUrl("jdbc:sequelink://localhost:2399;serverDataSource=rm");
		defaultDataSource.setUser("Admin");
		defaultDataSource.setPassword("admin");*/
		
		
		Connection connection = null;
		try {
			Class.forName("com.ddtek.jdbc.sequelink.SequeLinkDriver");
			connection = DriverManager.getConnection("jdbc:sequelink://localhost:2399", "Admin", "admin");
			//Connection connection = defaultDataSource.getConnection();
			String sql = "INSERT INTO resourceElement (\"dbElementId\",\"dbElementType\",\"dbElementInteger\",\"dbElementFloat\" ) VALUES('id001','resourceType',NULL,15.0000326)";
			Statement stmt = connection.createStatement();
			int success = stmt.executeUpdate(sql);
			logger.info("statement executed with success?:"+success);
			connection.commit();
			//connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			try {
				logger.info("try to rollback connection");
			connection.rollback();
			logger.info("rollback successful");
			} catch (Exception ex) {
				logger.error(ex.getCause());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			logger.info("execute finally");
			try {
				connection.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
		
	}

}
