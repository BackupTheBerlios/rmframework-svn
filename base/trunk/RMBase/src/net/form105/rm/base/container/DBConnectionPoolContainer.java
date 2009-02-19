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
package net.form105.rm.base.container;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


import org.apache.log4j.Logger;
import org.picocontainer.Startable;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * The connection pool creates a connection to a jdbc database based on the c3p0 connection
 * helper. Please visit <a href="http://sourceforge.net/projects/c3p0" /> to get advanced 
 * information about this software. There are some system properties required to start the 
 * connection pool successfully. These are:
 * 
 * <ul>
 * <li>connection.jdbcDriver</li>
 * <li>connection.jdbcUrl</li>
 * <li>connection.user</li>
 * <li>connection.password</li>
 * </ul>
 * 
 * 
 * defaultJdbcDriver = propContainer.getProperty("connection.jdbcDriver");
		defaultJdbcUrl = propContainer.getProperty("connection.jdbcUrl");
		user = propContainer.getProperty("connection.user");
		password = propContainer.getProperty("connection.password");
 * 
 * @author heikok
 *
 */
public class DBConnectionPoolContainer implements Startable {

	public static Logger logger = Logger.getLogger(DBConnectionPoolContainer.class);
	
	

	private String defaultJdbcDriver;
	private String defaultJdbcUrl;
	private String user;
	private String password;

	private ComboPooledDataSource defaultDataSource;
	private PropertiesContainer propContainer;
	private Connection connection = null;
	
	

	public DBConnectionPoolContainer(PropertiesContainer propContainer) {
		this.propContainer = propContainer;
	}
	
	@Override
	public void start() {
		initialize();
		defaultDataSource = new ComboPooledDataSource();
		try {
			defaultDataSource.setDriverClass(defaultJdbcDriver);
		} catch (PropertyVetoException e) {
			logger.error(e, e);
		}
		defaultDataSource.setJdbcUrl(defaultJdbcUrl);
		defaultDataSource.setUser(user);
		defaultDataSource.setPassword(password);
		
	}

	public void initialize() {
		defaultJdbcDriver = propContainer.getProperty("connection.jdbcDriver");
		defaultJdbcUrl = propContainer.getProperty("connection.jdbcUrl");
		user = propContainer.getProperty("connection.user");
		password = propContainer.getProperty("connection.password");
		
	}

	/**
	 * Getting the default connection which is provided with default settings
	 * configured in the system properties.
	 * @return
	 * @throws SQLException
	 */
	public Connection getDefaultConnection() throws SQLException {
		if (connection == null) {
			connection = defaultDataSource.getConnection();
		}
		return connection;
	}
	
	public void selectAll() {
		
	}

	

	@Override
	public void stop() {
		
	}

}
