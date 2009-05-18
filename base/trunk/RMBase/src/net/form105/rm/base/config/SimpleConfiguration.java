package net.form105.rm.base.config;

import net.form105.rm.base.IConfiguration;

public class SimpleConfiguration implements IConfiguration {

    public String getConfigurationPath() {
        return "config/";
    }

    public String getImportPath() {
        return "import/";
    }

    public String getContainerFile() {
        return "container.xml";
    }

    public ConfigurationType getType() {
        return ConfigurationType.SIMPLE;
    }

    public String getModelPath() {
        return "model/";
    }

    public String getBasePath() {
        return ".";
    }

}
