package net.form105.rm.base.config;

import net.form105.rm.base.IConfiguration;

public class SimpleClientConfiguration implements IConfiguration {

	@Override
	public String getConfigurationPath() {
		return "config/";
	}
	
	@Override
	public String getImportPath() {
		return "import/";
	}

	@Override
	public String getContainerFile() {
		return "clientContainer.xml";
	}

	@Override
	public ConfigurationType getType() {
		return ConfigurationType.SIMPLE;
	}

	

}
