/*
 * PropertiesContainer.java, Oct 28, 2007, 4:58:11 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base.container;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.picocontainer.Startable;

import com.form105.rm.base.Container;

/**
 *
 * @author heiko
 */
public class PropertiesContainer extends AbstractContainer implements Startable {
	
	public static Logger logger = Logger.getLogger(PropertiesContainer.class);

    private FileInputStream fiStream;
    private Properties properties;
    private String propFile = "config/server.properties.xml";
    
    
    public PropertiesContainer() {
    	super();
    	
    	String path = Container.getInstance().getConfiguration().getConfigurationDirectory();
    	propFile = path + "server.properties.xml";
    }

    public void start() {
        try {
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

    public void initialize() {
        logger.info("##### initialize #####");
    }

    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
