package net.form105.rm.base;

import net.form105.rm.base.config.ConfigurationType;

public interface IConfiguration {
	
	/**
	 * The path where the configuration files will be found
	 * @return
	 */
	public abstract String getConfigurationPath();
	
	public abstract String getImportPath();
	
	/**
	 * The name of the file where the containers are defined in. From this file the pico containers
	 * will be loaded.
	 * @return
	 */
	public abstract String getContainerFile();
	
	
	public abstract ConfigurationType getType();

}
