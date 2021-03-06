/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.form105.rm.base.config;

import java.io.File;

import net.form105.rm.base.IConfiguration;

/**
 * Creates a configuration based on a system property.
 * @author heiko
 *
 */
public class PropertyConfiguration implements IConfiguration {
    
    private String property;
    
    private String basePath;
    private String configPath;
    private String containerFile = "container.xml";
    private String importPath;
    private String modelPath;
    
    
    public PropertyConfiguration() {
        this("rmbase.home.dir");
    }
    
    public PropertyConfiguration(String property) {
        this.property = property;
        if (! isValid()) {
            System.err.println("Path is not valid (Value="+getPropertyValue()+"). Exiting now ...");
            System.exit(1);
        } else {
            basePath = getPropertyValue()+File.separator;
            configPath = getPropertyValue()+File.separator+"config"+File.separator;
            importPath = getPropertyValue()+File.separator+"import"+File.separator;
            modelPath = getPropertyValue()+File.separator+"model"+File.separator;
        }
    }

    public String getConfigurationPath() {
        return configPath;
    }

    public String getContainerFile() {
        return containerFile;
    }

    public String getImportPath() {
        return importPath;
    }

    public String getModelPath() {
        return modelPath;
    }

    public ConfigurationType getType() {
        return ConfigurationType.SIMPLE_PROPERTY;
    }
    
    public boolean isSet() {
        if (getPropertyValue() != null) {
            return true;
        }
        return false;
    }
    
    public String getPropertyValue() {
        return System.getProperty(property);
    }
    
    /**
     * Validate the given property. Check if it isn't null and the directoy exists.
     * @return
     */
    public boolean isValid() {
        File homeDir;
        if (isSet()) {
            homeDir = new File(getPropertyValue());
            return homeDir.exists();
        }
        return false;
    }

    public String getBasePath() {
        return basePath;
    }
    
    

}
