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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import net.form105.rm.base.Container;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.picocontainer.Startable;

/**
 * This container loads Logger with a predefined set of properties. The log4j properties are
 * read from the log4j properties file and if the rmbase.home.dir has been set, the file entries
 * will be checked and replaced with the local path of the rmbase.home.dir-property.
 * @author heikok
 *
 */
public class PropertiesLoggerContainer extends AbstractContainer implements Startable {
	
	PropertiesContainer propContainer;
	
	protected final String LOG4J_PROP = "log4j.properties";
	
	public void start() {
		String configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
        String configFile = configDir+File.separator+LOG4J_PROP;
        
        Properties log4jProps = replaceLog4jFileEntries(new File(configFile), System.getProperty("rmbase.home.dir"));
        
        PropertyConfigurator.configure(log4jProps);
        
        
        
	}
	
	public void stop() {
        LogManager.shutdown();
    }
	
	public Properties replaceLog4jFileEntries(File log4jFile, String homeDir) {
		Properties log4jProps = new Properties();
		Properties redefinedProps = new Properties();

		try {
			FileInputStream fiStream = new FileInputStream(log4jFile);
			log4jProps.load(fiStream);
			Set<Object> keys = log4jProps.keySet();
			for (Object object:keys) {
				String key = (String) object;
				StringBuffer sb = new StringBuffer(key.trim());
				int lastSlashIndex = sb.lastIndexOf(".");
				String lastEntry = sb.substring(lastSlashIndex + 1, sb.length());
				if (lastEntry.equals("File")) {
					File fileEntry = createLogDir(homeDir, log4jProps.getProperty(key));
					System.out.println("Redefine entry for log4j: "+key+":"+fileEntry.getCanonicalPath());
					redefinedProps.setProperty(key, fileEntry.getCanonicalPath());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log4jProps.putAll(redefinedProps);
		return log4jProps;
		
	}
	
	public File createLogDir(String homeDir, String relativePath) {
		StringBuffer homeDirBuffer = new StringBuffer(homeDir);
		StringBuffer relPathBuffer = new StringBuffer(relativePath);
		if (! relativePath.startsWith(File.separator)) {
			
			if (relativePath.startsWith(".")) {
				relPathBuffer.deleteCharAt(0);
			}
			
		}
		
		File logFile = new File(homeDirBuffer.append(File.separator).append(relPathBuffer).toString());
		logFile.getParentFile().mkdirs();
		return logFile;
	}
	
	

}
