/*
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.container;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import net.form105.rm.base.query.IQueryHandler;
import net.form105.rm.base.service.IServiceHandler;

import org.picocontainer.Startable;


/**
 * The client container provides a connection to the rmi server. The parameters server.rmi.port and server.rmihost will be
 * provided by the system properties. 
 * @author hk
 *
 */
public class RMIClientContainer extends AbstractContainer implements Startable {

    private ClientPropertiesContainer popertiesContainer;
    private int port;
    private String host;
    private IServiceHandler serviceHandler;
    private IQueryHandler<?> queryHandler;
    private String serviceHandlerUrl;
    private String queryHandlerUrl;

    public RMIClientContainer(ClientPropertiesContainer propertiesContainer) {
        this.popertiesContainer = propertiesContainer;
    }

    public void start() {
        // Configuring the client stack
        logger.info("Initialize RMI Parameters ...");

        Properties props = this.popertiesContainer.getProperties();
        port = new Integer(props.getProperty("server.rmi.port"));
        host = props.getProperty("server.rmi.host");


        // configure url 
        serviceHandlerUrl = "rmi://" + host + ":" + port + "/ServiceHandler";
        logger.info("Service handler RMI url is: "+serviceHandlerUrl);
        queryHandlerUrl = "rmi://" + host + ":" + port + "/QueryHandler";
        logger.info("Query handler RMI url is: "+queryHandlerUrl);
        
        try {
            serviceHandler = (IServiceHandler) Naming.lookup(serviceHandlerUrl);
            queryHandler = (IQueryHandler<?>) Naming.lookup(queryHandlerUrl);
        } catch (NotBoundException nbex) {
            logger.error("ServiceHandler not bound to registry.", nbex);
        } catch (MalformedURLException muex) {
            logger.error(muex, muex);
        } catch (RemoteException rex) {
            logger.error(rex, rex);
        }
    }

    public void stop() {
    	try {
			Naming.unbind(serviceHandlerUrl);
			Naming.unbind(queryHandlerUrl);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	serviceHandler = null;
    }

    public IServiceHandler getServiceHandler() {
        return serviceHandler;
    }
    
    public IQueryHandler getQueryHandler() {
    	return queryHandler;
    }
}
