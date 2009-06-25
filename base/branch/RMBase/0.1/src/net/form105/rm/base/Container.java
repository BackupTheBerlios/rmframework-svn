/*
 * XMLContainer.java, Oct 21, 2007, 9:21:12 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base;

import java.io.File;
import java.util.List;

import net.form105.rm.base.util.xml.XMLLoader;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.PicoContainer;
import org.picocontainer.behaviors.Caching;



/**
 * The PicoContainer used for starting basic services. The individual classes
 * will be loaded from an xml file in the config folder. Each class that
 * should be instantiated must be included in the container.xml file. 
 * The PicoContainer is a IoC Container which resolves its dependencies
 * automatically and instantiates each required class to fullfill the
 * instantiation parameters.
 * The factoryContainer is a container to fetch instances by a class name.
 * @author heiko
 */
public class Container {

    private Logger logger = Logger.getLogger(Container.class);
    private static Container instance;
    private static DefaultPicoContainer container;
    private static DefaultPicoContainer factoryContainer;
    
    private ContainerConfiguration configuration;

    static {
        
    	instance = new Container();
        instance.initialize();
        
    }

    public void initialize() {
        container = new DefaultPicoContainer(new Caching());
        factoryContainer = new DefaultPicoContainer();
        
    }

    /**
     * Static method to get a pico container singleton
     * @return
     */
    public static PicoContainer getContainer() {
        return container;
    }
    
    /**
     * Static method to get a pico container singleton which returns an instance of a class
     * @return
     */
    public static PicoContainer getFactoryContainer() {
    	return factoryContainer;
    }
    
    public static Container getInstance() {
    	return instance;
    }
    

    /**
     * Building the pico container based on the nano container. To create a pico container a configuration must be available
     * @param builder
     * @param parentContainer
     * @param scope
     * @return
     */
    public void load(ContainerConfiguration configuration) {
    	this.configuration = configuration;
    	
    	// check for log4j config file
    	
    	
    	// 1st of all - load log4j
    	String configDir = configuration.getConfigurationDirectory();
    	String log4jConfigPath = configDir + "log4j.properties";
    	File file = new File(log4jConfigPath);
    	if (!file.exists()) {
    		System.err.println("Error: Log4j configuration file doesn't exit: "+log4jConfigPath);
    	}
        PropertyConfigurator.configureAndWatch(configDir+File.separator+"log4j.properties");
        logger = Logger.getLogger(Container.class);
    	
    	
        XMLLoader loader = new XMLLoader(configuration.getPath());
        Document document = loader.parseFile();
        Element rootElement = document.getRootElement();
        List<Element> classElements = rootElement.elements();
        
        for (Element element : classElements) {
            
            try {
            	if (element.attribute("factory") == null) {
                String className = element.attributeValue("class");
                logger.info("Loading class for container: "+className);
                Class containerClass = Class.forName(className);
                container.addComponent(containerClass);
            	} else {
            		String className = element.attributeValue("class");
            		String key = element.attributeValue("key");
                    logger.info("Loading class for factory container: "+className);
                    Class containerClass = Class.forName(className);
                    factoryContainer.addComponent(key, containerClass);
            	}
                
            } catch (ClassNotFoundException ex) {
                logger.error(ex, ex);
            }
        }
        container.start();
        
    }
    
    public void stopAll() {
    	container.stop();
    }
    
    /**
     * Get the configuration for this container
     * @return
     */
    public ContainerConfiguration getConfiguration() {
    	return configuration;
    }
    
    public void unload() {
    	container.stop();
    	factoryContainer.stop();
    }
    
    
    
}
