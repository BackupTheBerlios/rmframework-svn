/*
 * XMLContainer.java, Oct 21, 2007, 9:21:12 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base;

import com.form105.rm.base.model.xml.XMLLoader;
import java.util.List;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.openide.util.Exceptions;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.PicoContainer;
import org.picocontainer.behaviors.Caching;
import org.picocontainer.lifecycle.ReflectionLifecycleStrategy;
import org.picocontainer.lifecycle.StartableLifecycleStrategy;
import org.picocontainer.monitors.LifecycleComponentMonitor;


/**
 * The PicoContainer used for starting basic services. The individual classes
 * will be loaded from an xml file in the config folder. Each class that
 * should be instantiated must be included in the container.xml file. 
 * The PicoContainer is a IoC Container which resolves its dependencies
 * automatically and instantiates each required class to fullfill the
 * instantiation parameters.
 * @author heiko
 */
public class Container {

    private Logger logger = Logger.getLogger(Container.class);
    private static Container instance;
    private static DefaultPicoContainer container;

    static {
        instance = new Container();
        instance.initialize();
    }

    public void initialize() {
        /*Reader script = null;
        try {

            script = new FileReader("config/container.xml");
            XMLContainerBuilder builder = new XMLContainerBuilder(script, getClass().getClassLoader());
            container = buildContainer(builder, null, "SOME_SCOPE");
        } catch (FileNotFoundException ex) {
            logger.info(ex, ex);
        } catch (Exception ex) {
            logger.info(ex, ex);
        } finally {
            try {
                File file = new File(".");
                logger.info(file.getCanonicalPath());
                script.close();

            } catch (IOException ex) {
                logger.info(ex);
            }
        }*/
        
        container = new DefaultPicoContainer(new Caching());
        
        load();
        container.start();
    }

    /**
     * Static method to get a pico container singleton
     * @return
     */
    public static PicoContainer getInstance() {
        return container;
    }

    /**
     * Building the pico container based on the nano container
     * @param builder
     * @param parentContainer
     * @param scope
     * @return
     */
    /*public PicoContainer buildContainer(ScriptedContainerBuilder builder, PicoContainer parentContainer, Object scope) {

        ObjectReference containerRef = new SimpleReference();
        ObjectReference parentContainerRef = new SimpleReference();

        parentContainerRef.set(parentContainer);
        builder.buildContainer(containerRef, parentContainerRef, scope, true);
        return (PicoContainer) containerRef.get();
    }*/
    
    private void load() {
        XMLLoader loader = new XMLLoader("config/container.xml");
        Document document = loader.parseFile();
        Element rootElement = document.getRootElement();
        logger.info("Root element of container.xml:"+rootElement.getName());
        List<Element> classElements = rootElement.elements();
        
        for (Element element : classElements) {
            
            try {
                String className = element.attributeValue("class");
                logger.info("Loading class for container: "+className);
                Class containerClass = Class.forName(className);
                container.addComponent(containerClass);
                
            } catch (ClassNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
}
