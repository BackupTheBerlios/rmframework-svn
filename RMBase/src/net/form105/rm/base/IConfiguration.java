package net.form105.rm.base;

import net.form105.rm.base.config.ConfigurationType;

public interface IConfiguration {
	
	/**
	 * The path where the configuration files will be found
	 * @return
	 */
	public String getConfigurationPath();
	
	/**
	 * The name of the file where the containers are defined in. From this file the pico containers
	 * will be loaded.
	 * @return
	 */
	public String getContainerFile();
	
	
	public ConfigurationType getType();

}
