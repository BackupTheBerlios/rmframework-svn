package com.epac.plugin.dbIntegration.jdbc.mySql;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.epac.plugin.dbIntegration.meta.MetaColumn;
import com.epac.plugin.dbIntegration.meta.MetaIndex;
import com.epac.plugin.dbIntegration.meta.MetaTable;
import com.epac.plugin.dbIntegration.meta.MetaType;
import com.epac.plugin.dbIntegration.meta.statement.CreateTableStatementCreator;
import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * <entry key="connection.jdbcDriver">com.ddtek.jdbc.sequelink.SequeLinkDriver</entry>
 * <entry key="connection.jdbcUrl">jdbc:sequelink://localhost:2399;serverDataSource=rm</entry>
 * <entry key="connection.user">Admin</entry>
 * <entry key="connection.password">admin</entry>
**/

public class MySqlMetaData {
	
	private String jdbcDriver;
	private String jdbcUrl;
	private String user;
	private String passwd;
	private Connection connection;
	
	private Map<String, MetaTable> tableMap;
	
	
	
	@Before
	public void initialize() {
		this.jdbcDriver = "com.mysql.jdbc.Driver";
		this.jdbcUrl = "jdbc:mysql://localhost:3306/ina";
		this.user = "admin";
		this.passwd= "admin";
		this.connection = getConnection();
	}
	
	public Connection getConnection() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection connection = null;
		try {
			dataSource.setDriverClass(jdbcDriver);
			dataSource.setJdbcUrl(jdbcUrl);
			dataSource.setUser(user);
			dataSource.setPassword(passwd);
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;	
	}
	
	public void loadMetaData() {
		try {
			DatabaseMetaData md = connection.getMetaData();
			ResultSet rs = md.getTables("ina", null, null, null);
			tableMap = new HashMap<String, MetaTable>();
			
			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
				MetaTable mTable = new MetaTable(tableName, tableName);
				
				ResultSet indexInfo = md.getIndexInfo("ina", null, tableName, false, false);
				while (indexInfo.next()) {
					String indexColName = indexInfo.getString("COLUMN_NAME");
					mTable.addIndex(new MetaIndex(indexColName, indexColName));
				}
				tableMap.put(tableName, mTable);
			}
			
			rs = md.getColumns("ina", null, null, null);
			while (rs.next()) {
				
				String tableName = rs.getString("TABLE_NAME");
				String colName = rs.getString("COLUMN_NAME");
				boolean isNullable =  rs.getBoolean("IS_NULLABLE");
				int colSize = rs.getInt("COLUMN_SIZE");
				String colType = rs.getString("TYPE_NAME").replaceAll(" ", "");
				MetaType colTypeEnum = MetaType.valueOf(colType);
				
				MetaColumn mCol = new MetaColumn(colName, colName, colTypeEnum, isNullable, colSize);	
				tableMap.get(tableName).addColumn(mCol);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void connectToFM() {
		
	}
	
	@Test
	public void createSchemaOnFM() {
		loadMetaData();
		createTableStatement();
		
		ComboPooledDataSource dataSourceFM = new ComboPooledDataSource();
		
		Connection connectionFM = null;
		try {
			
			dataSourceFM.setDriverClass(jdbcDriver);
			dataSourceFM.setJdbcUrl(jdbcUrl);
			dataSourceFM.setUser(user);
			dataSourceFM.setPassword(passwd);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		try {
			connectionFM = dataSourceFM.getConnection();
			Statement statement = connectionFM.createStatement();
			//statement.execute(sql)
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create table <tablename> (C1 VARCHAR NOT NULL)
	 */
	private void createTableStatement() {
		
		Iterator<MetaTable> iter = tableMap.values().iterator();
		while (iter.hasNext()) {
			CreateTableStatementCreator statement = new CreateTableStatementCreator(iter.next());
			StringBuffer statementBuffer = statement.getStatement();
			System.out.println(statementBuffer);
		}
		
	}
	
	
	
	
	
	

}
