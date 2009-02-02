package net.form105.rm.base.config;

import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.IConfiguration;

public class WebConfiguration implements IConfiguration {

    protected String configurationPath;
    protected String importPath;
    protected String containerFile = "container.xml";
    protected String modelPath;
    
    protected ContainerConfiguration configuration;

    @Override
    public String getConfigurationPath() {
        return configurationPath;
    }

    @Override
    public String getContainerFile() {
        return containerFile;
    }

    @Override
    public ConfigurationType getType() {
        return ConfigurationType.WEB;
    }

    /**
     * Inject the configuration path by the web listener
     * @param path
     */
    public void setConfigurationPath(String path) {
        this.configurationPath = path;
    }

    /**
     * Inject the import path
     * @param path
     */
    public void setImportPath(String path) {
        this.importPath = path;
    }

    public void setConfiguration(ContainerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getImportPath() {
        return importPath;
    }

    public void setModelPath(String path) {
        this.modelPath = path;
    }
    
    @Override
    public String getModelPath() {
        return modelPath;
    }

}
