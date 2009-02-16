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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.form105.rm.base.db.mapping.MappingColumn;


public class CreateResourceTest {
	
	@MappingColumn(fieldName="elementId", fieldType="VARCHAR")
	private String elementId;
	
	@MappingColumn(fieldName="elementName", fieldType="VARCHAR")
	private String elementName;
	
	@MappingColumn(fieldName="elementType", fieldType="VARCHAR")
	private String elementType;
	
	public static Logger logger = Logger.getLogger(CreateResourceTest.class);
	
	//@Test
	public void createResource() {
		// create a simple resource with 
		Resource resource = new Resource("bcrXXX", "Name of bcr", "type of bcr");
		saveResource(resource);
	}
	
	
	
	
	public void saveResource(Resource resource) {
		FileMakerConnectionTest connector = new FileMakerConnectionTest();
		Connection connection = connector.connect();
		try {
			Statement stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery("select * from resourceElement where elementId = "+resource.getElementId());
			if (! rs.next()) {
				
			}
			
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer.append("insert into resourceElement ");
			sqlBuffer.append("(elementId, elementName, elementType) ");
			sqlBuffer.append("VALUES ('");
			sqlBuffer.append(resource.getElementId()).append("',");
			sqlBuffer.append("'").append(resource.getName()).append("',");
			sqlBuffer.append("'").append(resource.getType()).append("'");
			sqlBuffer.append(")");
			logger.info(sqlBuffer.toString());
			stmt.executeUpdate(sqlBuffer.toString());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getCompleteTable(String tableName, Connection connection) throws SQLException {
		Statement stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from ").append(tableName);
		return stmt.executeQuery(buffer.toString());
	}

	


}
