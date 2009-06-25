package net.form105.rm.base.config;

import com.db4o.foundation.NotSupportedException;

import net.form105.rm.base.IConfiguration;

public class SimpleClientConfiguration implements IConfiguration {

    public String getConfigurationPath() {
        return "config/";
    }

    public String getImportPath() {
        return "import/";
    }

    public String getContainerFile() {
        return "clientContainer.xml";
    }

    public ConfigurationType getType() {
        return ConfigurationType.SIMPLE;
    }

    public String getModelPath() {
        throw new NotSupportedException();
    }

    public String getBasePath() {
        return ".";
    }

}
