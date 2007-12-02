/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base.container;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
        this.propContainer = propContainer;
        
    }

    public void start() {
        props = propContainer.getProperties();
        port = new Integer(props.getProperty("server.rmi.port"));
        
        logger.info("Starting registry on port: "+port);
        try {
            registry = LocateRegistry.createRegistry(port);
        } catch (RemoteException ex) {
            logger.error(ex, ex);
        }
    }

    public void stop() {
        
    }

    /**
     * Get the initialized registry
     * @return The registry
     */
    public Registry getRegistry() {
        return registry;
    }
}
