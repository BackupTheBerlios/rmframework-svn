package net.form105.rm.base;

import net.form105.rm.base.config.ConfigurationType;

public interface IConfiguration {
	
	/**
	 * The path where the configuration files will be found
	 * @return
	 */
	public abstract String getConfigurationPath();
	
	/**
	 * The path where the import folder resides
	 * @return The import folder
	 */
	public abstract String getImportPath();
	
	/**
	 * The path where the server models reside.
	 * @return The model folder
	 */
	public abstract String getModelPath();
	
	/**
	 * The name of the file where the containers are defined in. From this file the pico containers
	 * will be loaded.
	 * @return
	 */
	public abstract String getContainerFile();
	
	
	public abstract ConfigurationType getType();
	
	/**
	 * The path to the working directory.
	 * @return
	 */
	public abstract String getBasePath();

}
