/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.container;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import net.form105.rm.base.query.RMIQueryHandler;
import net.form105.rm.base.service.RMIServiceHandler;

import org.picocontainer.Startable;


/**
 * A container which is responsible to register a query handler at the rmi registry.
 * @author heiko
 *
 */
public class RMIQueryHandlerContainer extends AbstractContainer implements Startable {
    
    private RMIServerContainer rmiServerContainer;
    private RMIQueryHandler rmiQueryHandler;
    
    public RMIQueryHandlerContainer(RMIServerContainer rmiServerContainer) throws RemoteException {
    	super();
        this.rmiServerContainer = rmiServerContainer;
        rmiQueryHandler = new RMIQueryHandler();
    }

    public void start() {
        logger.info("Starting: Binding RMIQueryHandler to the registry.");
        try {
            Registry registry = rmiServerContainer.getRegistry();
            registry.rebind(rmiQueryHandler.getName(), rmiQueryHandler);
        } catch (RemoteException ex) {
           logger.error("Error in rebinding the RMIQueryHandler to the registry", ex);
        } 
        
        
    }

    public void stop() {
    	logger.info("Stopping container: "+getClass().getCanonicalName());
        try {
            Registry registry = rmiServerContainer.getRegistry();
            registry.unbind(rmiQueryHandler.getName());
            UnicastRemoteObject.unexportObject(rmiQueryHandler, true);
        } catch (RemoteException ex) {
            logger.error("Error in unbinding the RMIQueryHandler from registry", ex);
        } catch (NotBoundException ex) {
            logger.error("Error in unbinding the RMIQueryHandler from registry", ex);
        }
    }
    
    public RMIQueryHandler getQueryHandler() {
        return rmiQueryHandler;
    }

}
