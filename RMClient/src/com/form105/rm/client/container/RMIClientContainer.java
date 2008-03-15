/*
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.client.container;

import com.form105.rm.base.container.AbstractContainer;
import com.form105.rm.base.service.IServiceHandler;
import com.form105.rm.base.service.RMIServiceHandler;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Properties;
import org.picocontainer.Startable;

public class RMIClientContainer extends AbstractContainer implements Startable {

    private PropertiesContainer popertiesContainer;
    private int port;
    private String host;
    private IServiceHandler serviceHandler;
    private String serviceHandlerUrl;

    public RMIClientContainer(PropertiesContainer propertiesContainer) {
        this.popertiesContainer = propertiesContainer;
    }

    public void start() {
        // Configuring the client stack
        logger.info("Initialize RMI Parameters ...");

        Properties props = this.popertiesContainer.getProperties();
        port = new Integer(props.getProperty("server.rmi.port"));
        host = props.getProperty("server.rmi.host");


        /* See if the object is there... */
        serviceHandlerUrl = "rmi://" + host + ":" + port + "/ServiceHandler";
        logger.info("RMI Url is: rmi://" + host + ":" + port + "/ServiceHandler");




    }

    public void stop() {

    }

    public IServiceHandler getServiceHandler() {
        serviceHandler = null;
        try {
            Remote remote = Naming.lookup(serviceHandlerUrl);
            serviceHandler = (IServiceHandler) Naming.lookup(serviceHandlerUrl);
        } catch (NotBoundException nbex) {
            logger.error("ServiceHandler not bound to registry.", nbex);
        } catch (MalformedURLException muex) {
            logger.error(muex, muex);
        } catch (RemoteException rex) {
            logger.error(rex, rex);
        }
        return serviceHandler;
    }
}
