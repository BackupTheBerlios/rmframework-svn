package net.form105.rm.base.config;

import java.io.File;
import java.io.IOException;

import net.form105.rm.base.IConfiguration;

public class SimpleConfiguration implements IConfiguration {

    public String getConfigurationPath() {
        return "config/";
    }

    public String getImportPath() {
        return "import/";
    }

    public String getContainerFile() {
    	if (System.getProperty("rm.config.fileName") != null) {
    		return System.getProperty("rm.config.fileName");
    	}
        return "container.xml";
    }

    public ConfigurationType getType() {
        return ConfigurationType.SIMPLE;
    }

    public String getModelPath() {
        return "model/";
    }

    public String getBasePath() {
    	try {
    		File file = new File(".");
    		return file.getCanonicalPath()+File.separator;
		} catch (IOException e) {
			e.printStackTrace();
			return ".";
		}
        
    }

}
