/*
 * Agent.java, Oct 21, 2007, 9:14:38 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base;

import net.form105.rm.base.config.SimpleConfiguration;
import net.form105.rm.base.container.LookupContainer;
import net.form105.rm.base.container.PropertiesContainer;
import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.AgentObject;

/**
 * The main class which starts the agent and gives access to the 
 * containers started initially.
 * @author heiko
 */
public class Agent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
    	ContainerConfiguration configuration = new ContainerConfiguration(new SimpleConfiguration());
        Container.getInstance().load(configuration);
    }

    /**
     * Getting an container instance registered at the pico container
     * @param clazz
     * @return
     */
    public static Object getContainer(Class clazz) {
        Object container = Container.getContainer().getComponent(clazz);
        if (container == null) {
            System.err.println("Container: " + clazz.getSimpleName() + " doesn't exist as a registered container. Server hasn't been started?");
            return null;
        } else {
            return container;
        }
    }
    
    /**
     * Getting the dao lookup
     * @return
     */
    public static ILookup getDaoLookup() {
        LookupContainer container = (LookupContainer) Container.getContainer().getComponent(LookupContainer.class);
        return container.getDaoLookup();
    }

    public static String getRMProperty(String key) {
        PropertiesContainer container = (PropertiesContainer) getContainer(PropertiesContainer.class);
        if (container == null) {
        	// try to get a property directly from system properties
        	return System.getProperty(key);
        }
        return container.getProperty(key);
    }

    public static ILookup getLookup() {
        LookupContainer container = (LookupContainer) getContainer(LookupContainer.class);
        return container.getGlobalLookup();
    }
    
}
