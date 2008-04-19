/*
 * XMLContainer.java, Oct 21, 2007, 9:21:12 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.log4j.Logger;
import org.nanocontainer.script.ScriptedContainerBuilder;
import org.nanocontainer.script.xml.XMLContainerBuilder;
import org.picocontainer.PicoContainer;
import org.picocontainer.defaults.ObjectReference;
import org.picocontainer.defaults.SimpleReference;

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
    private static PicoContainer container;

    static {
        instance = new Container();
        instance.initialize();
    }

    public void initialize() {
        Reader script = null;
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
        }
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
    public PicoContainer buildContainer(ScriptedContainerBuilder builder, PicoContainer parentContainer, Object scope) {

        ObjectReference containerRef = new SimpleReference();
        ObjectReference parentContainerRef = new SimpleReference();

        parentContainerRef.set(parentContainer);
        builder.buildContainer(containerRef, parentContainerRef, scope, true);
        return (PicoContainer) containerRef.get();
    }
}
