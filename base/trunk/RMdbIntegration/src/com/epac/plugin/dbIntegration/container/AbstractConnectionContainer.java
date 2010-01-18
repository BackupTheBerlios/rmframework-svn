package com.epac.plugin.dbIntegration.container;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import net.form105.rm.base.container.AbstractContainer;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public abstract class AbstractConnectionContainer extends AbstractContainer {
	
	public static Logger logger = Logger.getLogger(AbstractConnectionContainer.class);

	private String jdbcDriver;
	private String jdbcUrl;
	private String user;
	private String passwd;
	private Connection connection;

	
	/**
	 * Get the jdbc connection for executing sql statement
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}
	
	public void stop() {
		try {
			getConnection().close();
		} catch (SQLException e) {
			// do nothing .. we close only
		}
	}
	

	/**
	 * Initializes the JDBC connection
	 * @param jdbcDriver
	 * @param jdbcUrl
	 * @param user
	 * @param passwd
	 */
	protected void initializeConnection(String jdbcDriver, String jdbcUrl, String user, String passwd) {
		
		if (connection == null) {
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			try {
				this.jdbcDriver = jdbcDriver;
				this.jdbcUrl = jdbcUrl;
				this.user = user;
				this.passwd = passwd;
				dataSource.setDriverClass(jdbcDriver);
				dataSource.setJdbcUrl(jdbcUrl);
				dataSource.setUser(user);
				dataSource.setPassword(passwd);
				connection = dataSource.getConnection();
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @return the jdbcDriver
	 */
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	/**
	 * @param jdbcDriver
	 *            the jdbcDriver to set
	 */
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	/**
	 * @return the jdbcUrl
	 */
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	/**
	 * @param jdbcUrl
	 *            the jdbcUrl to set
	 */
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
