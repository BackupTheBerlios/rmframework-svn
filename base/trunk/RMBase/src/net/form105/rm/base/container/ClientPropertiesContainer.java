 /*
 * PropertiesContainer.java, Oct 28, 2007, 4:58:11 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.container;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import net.form105.rm.base.Container;

import org.apache.log4j.Logger;
import org.picocontainer.Startable;


/**
 *
 * @author heiko
 */
public class ClientPropertiesContainer extends AbstractContainer implements Startable {
	
	public static Logger logger = Logger.getLogger(PropertiesContainer.class);

    private FileInputStream fiStream;
    private Properties properties;
    
    
    public ClientPropertiesContainer() {
    	super();
    	
    	
    }

    public void start() {
        try {
        	String path = Container.getInstance().getConfiguration().getConfigurationDirectory();
        	String propFile = path + "client.properties.xml";
        	
            setProperties(new Properties(System.getProperties()));
            fiStream = new FileInputStream(propFile);
            getProperties().loadFromXML(fiStream);
            for (Object o : getProperties().keySet()) {
                String s = (String) o;
                logger.info("RM Property: "+ s + "-> " + properties.getProperty(s));
            }

        } catch (FileNotFoundException ex) {
            logger.error(ex, ex);
        } catch (IOException iex) {

        } finally {
            try {
                fiStream.close();
            } catch (IOException ex) {
                logger.error(ex, ex);
            }
        }
        //logSystemProperties();
    }

    public void stop() {
        try {
            fiStream.close();
        } catch (IOException ex) {
            logger.error(ex, ex);
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getProperty(String key) {
        return (String) properties.get(key);
    }

    public void logSystemProperties() {
        Properties props = System.getProperties();

        for (Object keyObject : props.keySet()) {
            String sKey = (String) keyObject;
            logger.info("System properties key: " + sKey + " -> result: " + props.getProperty(sKey));
        }
    }

}
