package com.epac.plugin.dbIntegration.container;

import net.form105.rm.base.container.PropertiesContainer;

/**
 * A container to create the source connection to a JDBC database where we want to read the data out
 * @author heikok
 *
 */
public class SourceConnectionContainer extends AbstractConnectionContainer {
	
	private PropertiesContainer propContainer;
	
	public SourceConnectionContainer(PropertiesContainer propContainer) {
		this.propContainer = propContainer;
	}

	@Override
	public void start() {
		String jdbcDriver = propContainer.getProperty("connection.source.jdbcDriver");
		String jdbcUrl = propContainer.getProperty("connection.source.jdbcUrl");
		String user = propContainer.getProperty("connection.source.user");
		String passwd = propContainer.getProperty("connection.source.password");
		
		initializeConnection(jdbcDriver, jdbcUrl, user, passwd);
	}
}
