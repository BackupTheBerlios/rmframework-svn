package com.form105.rm.base.config;

import com.form105.rm.base.IConfiguration;

public class SimpleConfiguration implements IConfiguration {

	@Override
	public String getConfigurationPath() {
		return "config/";
	}

	@Override
	public String getContainerFile() {
		return "container.xml";
	}

	@Override
	public ConfigurationType getType() {
		return ConfigurationType.SIMPLE;
	}

}
