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
package net.form105.rm.base.container;

import java.io.File;

import net.form105.rm.base.Container;
import net.form105.rm.base.config.PropertyConfiguration;

import org.apache.log4j.PropertyConfigurator;

public class LoggerContainer extends PropertiesLoggerContainer {
    
    public LoggerContainer(PropertiesContainer propContainer) {
    	super(propContainer);
    }
    
    public void start() {
    	
    	if (Container.getInstance().getConfiguration().getConfiguration() instanceof PropertyConfiguration) {
    		super.start();
    		return;
    	}
    	
    	//createLogFolder();
        String configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
        String configFile = configDir+File.separator+LOG4J_PROP;   
        PropertyConfigurator.configureAndWatch(configFile);
    }
}
