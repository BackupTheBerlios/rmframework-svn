package net.form105.rm.base;

import net.form105.rm.base.config.ConfigurationType;

import org.apache.log4j.Logger;


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

	/**
	 * Getting the directory where the configuration file resides. 
	 * @return
	 */
	public String getConfigurationDirectory() {
		return configuration.getConfigurationPath();
	}
	
	/**
	 * Getting the configuration the container is started with
	 * @return The configuration
	 */
	public IConfiguration getConfiguration() {
		return configuration;
	}
	
	public String getImportDirectory() {
	    return configuration.getImportPath();
	}
	
	public String getModelDirectory() {
	    return configuration.getModelPath();
	}
	
	
	
	

}
