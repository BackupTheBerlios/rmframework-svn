package net.form105.rm.base;

import net.form105.rm.base.config.ConfigurationType;

public interface IConfiguration {
	
	public String getConfigurationPath();
	
	public String getContainerFile();
	
	public ConfigurationType getType();

}
