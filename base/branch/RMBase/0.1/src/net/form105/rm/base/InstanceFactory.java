/*
 * XMLContainer.java, Oct 21, 2007, 9:21:12 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base;

import java.util.List;

import net.form105.rm.base.util.xml.XMLLoader;

import org.apache.log4j.Logger;
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
 * @author heiko
 */
public class InstanceFactory {

    private Logger logger = Logger.getLogger(InstanceFactory.class);
    private static InstanceFactory instance;
    private static DefaultPicoContainer container;
    
    private ContainerConfiguration configuration;

    static {
        instance = new InstanceFactory();
        instance.initialize();
    }

    public void initialize() {
        container = new DefaultPicoContainer();
        
    }

    /**
     * Static method to get a pico container singleton
     * @return
     */
    public static PicoContainer getContainer() {
        return container;
    }
    
    public static InstanceFactory getInstance() {
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
        XMLLoader loader = new XMLLoader(configuration.getPath());
        Document document = loader.parseFile();
        Element rootElement = document.getRootElement();
        List<Element> classElements = rootElement.elements();
        
        for (Element element : classElements) {
            
            try {
                String className = element.attributeValue("class");
                logger.info("Loading class for container: "+className);
                Class containerClass = Class.forName(className);
                container.addComponent(containerClass);
                
            } catch (ClassNotFoundException ex) {
                logger.error(ex, ex);
            }
        }
        container.start();
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
    }
    
    
    
}
