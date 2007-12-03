/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.container;

import com.form105.rm.base.service.RMIServiceHandler;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import org.picocontainer.Startable;


public class RMIServiceHandlerContainer extends AbstractContainer implements Startable {
    
    private RMIServerContainer rmiServerContainer;
    private RMIServiceHandler rmiServiceHandler;
    
    public RMIServiceHandlerContainer(RMIServerContainer rmiServerContainer) throws RemoteException {
        this.rmiServerContainer = rmiServerContainer;
        rmiServiceHandler = new RMIServiceHandler();
    }

    public void start() {
        logger.info("Starting: Binding RMIServiceHandler to the registry.");
        try {
            Registry registry = rmiServerContainer.getRegistry();
            registry.rebind(rmiServiceHandler.getName(), rmiServiceHandler);
        } catch (RemoteException ex) {
            logger.error("Error in rebinding the RMIServiceHandler to the registry", ex);
        } 
        
        
    }

    public void stop() {
        try {
            Registry registry = rmiServerContainer.getRegistry();
            registry.unbind(rmiServiceHandler.getName());
        } catch (RemoteException ex) {
            logger.error("Error in unbinding the RMIServiceHandler from registry", ex);
        } catch (NotBoundException ex) {
            logger.error("Error in unbinding the RMIServiceHandler from registry", ex);
        }
    }
    
    public RMIServiceHandler getServiceHandler() {
        return rmiServiceHandler;
    }

}
