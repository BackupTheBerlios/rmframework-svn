package com.form105.rm.base;

import org.apache.log4j.Logger;

import com.form105.rm.base.config.ConfigurationType;

/**
 * The configuration for the PicoContainer. The configuration will be delegated by another class which should provide a 
 * IConfiguration. It provides a full path to a configuration file.
 * @author hk
 *
 */
public class ContainerConfiguration {
	
	public static Logger logger = Logger.getLogger(ContainerConfiguration.class);

	private IConfiguration configuration;
	
	public ContainerConfiguration(IConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public String getPath() {
		String configFile = configuration.getConfigurationPath() + configuration.getContainerFile();
		logger.info("Got path for container configuration: "+configFile);
		return configFile;
	}

	/**
	 * The type of the application. Which should be of kind like the enumerations provided by ConfigurationType
	 * @return
	 */
	public ConfigurationType getConfigurationType() {
		return configuration.getType();
	}


	
	

}
