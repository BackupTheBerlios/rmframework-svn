package com.epac.plugin.dbIntegration.container;

import net.form105.rm.base.container.PropertiesContainer;

/**
 * A container to create the source connection to a JDBC database where we want to write data to
 * @author heikok
 */
public class TargetConnectionContainer extends AbstractConnectionContainer {

private PropertiesContainer propContainer;
	
	public TargetConnectionContainer(PropertiesContainer propContainer) {
		this.propContainer = propContainer;
	}

	@Override
	public void start() {
		String jdbcDriver = propContainer.getProperty("connection.target.jdbcDriver");
		String jdbcUrl = propContainer.getProperty("connection.target.jdbcUrl");
		String user = propContainer.getProperty("connection.target.user");
		String passwd = propContainer.getProperty("connection.target.password");
		initializeConnection(jdbcDriver, jdbcUrl, user, passwd);
	}

}
