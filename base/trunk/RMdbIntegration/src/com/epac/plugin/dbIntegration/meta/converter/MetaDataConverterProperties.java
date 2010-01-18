package com.epac.plugin.dbIntegration.meta.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import net.form105.rm.base.Container;

import org.apache.log4j.Logger;

import com.epac.plugin.dbIntegration.meta.MetaType;

/**
 * Loads the properties for converting field types from one database to another
 * 
 * @author heikok
 * 
 */
public class MetaDataConverterProperties {
	
	public static Logger logger = Logger.getLogger(MetaDataConverterProperties.class);

	Properties properties;
	FileInputStream iStream;
	Properties props;

	Map<String, String> typeMap = new HashMap<String, String>();

	public MetaDataConverterProperties() {
		loadFile();
	}

	private void loadFile() {
		try {
			String configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
			System.out.println("config dir: " + configDir);
			iStream = new FileInputStream(new File(configDir+"MDConverter.properties"));
			properties = new Properties();
			properties.load(iStream);
			iStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean validateProperties() {
		Set keySet = properties.keySet();
		keySet.iterator();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = properties.getProperty(key);
			if (MetaType.valueOf(key) == null) {
				logger.error("Invalid Property: "+MetaType.valueOf(key).toString());
				return false;
			}
			if (MetaType.valueOf(value) == null) {
				logger.error("Invalid Property: "+MetaType.valueOf(value).toString());
				return false;
			}
		}
		return false;
	}
	
	public Map getConverterMap() {
		
		return properties;
	}
	


}
