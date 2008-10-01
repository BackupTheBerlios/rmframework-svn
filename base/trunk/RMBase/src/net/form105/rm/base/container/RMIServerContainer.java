/*
 * RMIServerContainer.java, Oct 28, 2007, 4:58:11 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.container;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import org.picocontainer.Startable;

/**
 *
 * @author heiko
 */
public class RMIServerContainer extends AbstractContainer implements Startable {

    private PropertiesContainer propContainer;
    private Properties props;
    private int port = 1099;
    private Registry registry;

    public RMIServerContainer(PropertiesContainer propContainer) {
    	super();
        this.propContainer = propContainer;
        
    }

    public void start() {
        props = propContainer.getProperties();
        port = new Integer(props.getProperty("server.rmi.port"));
        
        logger.info("Starting: RMI Registry on port: "+port);
        try {
            registry = LocateRegistry.createRegistry(port);
        } catch (RemoteException ex) {
            logger.error(ex, ex);
        }
    }

    public void stop() {
    	logger.info("Stopping RMIServerContainer");
    	try {
			UnicastRemoteObject.unexportObject(registry, true);
		} catch (NoSuchObjectException e) {
			e.printStackTrace();
		}
        
    }

    /**
     * Get the initialized registry
     * @return The registry
     */
    public Registry getRegistry() {
        return registry;
    }
}
