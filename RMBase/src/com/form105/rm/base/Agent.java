/*
 * Agent.java, Oct 21, 2007, 9:14:38 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base;

import com.form105.rm.base.config.SimpleConfiguration;
import com.form105.rm.base.container.GlobalLookupContainer;
import com.form105.rm.base.container.PropertiesContainer;
import com.form105.rm.base.lookup.EntryLookupRegistry;

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
            System.err.println("Container: " + clazz.getName() + " doesn't exist as a registered container");
            return null;
        } else {
            return container;
        }
    }

    public static String getRMProperty(String key) {
        PropertiesContainer container = (PropertiesContainer) getContainer(PropertiesContainer.class);
        return container.getProperty(key);
    }

    public static EntryLookupRegistry getLookup() {
        GlobalLookupContainer container = (GlobalLookupContainer) getContainer(GlobalLookupContainer.class);
        return container.getLookupRegistry();
    }
}
