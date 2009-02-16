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
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class FileMakerConnectionTest {

	public static Logger logger = Logger.getLogger(FileMakerConnectionTest.class);

	@Before
	public void setUp() throws Exception {
	}

	public Connection connect() {
		Connection connection = null;
		try {

			Driver driver = (Driver) Class.forName("com.ddtek.jdbc.sequelink.SequeLinkDriver").newInstance();
			connection = DriverManager
					.getConnection("jdbc:sequelink://localhost:2399;user=Admin;password=admin;serverDataSource=rm");
			// Connection connection =
			// DriverManager.getConnection("jdbc:sequelink://192.168.3.37:2399;user=Admin;password=admin;serverDataSource=rm");
			SQLWarning warning = connection.getWarnings();
			if (warning != null) {
				System.out.println(warning);
			}
			return connection;

		} catch (Exception e) {
			e.printStackTrace();
			return connection;
		}
	}

	public void getResources(Connection connection) {
		try {
			// Statement statement =
			// connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			// ResultSet.CONCUR_READ_ONLY);
			// ResultSet resultSet =
			// statement.executeQuery("select * from RESOURCE");
			PreparedStatement statement = connection.prepareStatement(getParametersByResourceSql("bcr01"));
			ResultSet resultSet = statement.executeQuery();
			int colCount = resultSet.getMetaData().getColumnCount();

			for (int i = 1; i < colCount; i++) {
				System.out.println(resultSet.getMetaData().getColumnLabel(i));
			}
			System.out.println(resultSet);
			while (resultSet.next()) {
				String elementId = resultSet.getString("ELEMENTID");
				String name = resultSet.getString("NAME");
				System.out.println(elementId + "-" + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String getParametersByResourceSql(String resourceId) {
		String query = new String("SELECT * from PARAMETER, RESOURCE where RESOURCE.ELEMENTID = '" + resourceId
				+ "' and '" + resourceId + "' = PARAMETER.RESOURCEID");
		System.out.println(query);
		return query;
	}

	public void saveOrUpdateResource() {
		Connection connection = connect();
		try {
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String sql = "select NAME from RESOURCE where RESOURCE.ELEMENTID = 'bcr01'";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			for (int j = 1; j <= metaData.getColumnCount(); j++) {
				logger.info("ColumnName: " + metaData.getColumnName(j));
				logger.info("Column Writable: " + metaData.isDefinitelyWritable(j));
			}
			rs.next();
			rs.updateString("NAME", "barcodereader number 1");
			rs.updateRow();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateParameter(Connection connection, String resourceId, String paramId, String value) {
		try {
			// PreparedStatement statement =
			// connection.prepareStatement(getParametersByResourceSql("bcr01"),
			// ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			//String sql = "SELECT * from PARAMETER where '" + resourceId + "' = PARAMETER.RESOURCEID";
			String sql = getParametersByResourceSql("bcr01");

			Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery(sql);

			ResultSetMetaData metaData = resultSet.getMetaData();
			for (int j = 1; j <= metaData.getColumnCount(); j++) {
				logger.info("ColumnName: " + metaData.getColumnName(j));
				logger.info("Column Writable: " + metaData.isDefinitelyWritable(j));
			}

			while (resultSet.next()) {
				if (resultSet.getString("ELEMENTID").equals(paramId)) {
					logger.info(resultSet.getString("VALUE"));
					resultSet.updateString("VALUE", value);
					resultSet.updateRow();
				}
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void run() {
		Connection connection = connect();

		try {
			//saveOrUpdateParameter(connection, "bcr01", "param06", "valueUpdate06");
			addParameter(connection, "");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addParameter(Connection connection, String resourceId) {
		try {
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from parameter");
			rs.moveToInsertRow();
			rs.updateString("ELEMENTID", "param10");
			rs.updateString("NAME", "StringParameter 10");
			rs.updateString("VALUE", "10");
			rs.updateString("TYPE", "string");
			rs.updateString("RESOURCEID", "XXX");
			rs.insertRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
