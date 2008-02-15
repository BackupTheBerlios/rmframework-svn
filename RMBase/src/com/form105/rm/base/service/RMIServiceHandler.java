/*
 * RMIServiceHandler.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.apache.log4j.Logger;

public class RMIServiceHandler extends UnicastRemoteObject implements IServiceHandler {
    
    private static Logger logger = Logger.getLogger(RMIServiceHandler.class);
    
    private final String name = "ServiceHandler";
    private IService service;
    private ServiceResult result = new ServiceResult();
    
    public RMIServiceHandler() throws RemoteException {
        super();
    }
    
    public void executeService(IService service) throws RemoteException {
        
        try {
        
        this.service = service;
        service.execute();
        result.setStatus(Status.SUCCESS);
        } catch (Exception ex) {
            result.setStatus(Status.FAIL);
            logger.error(ex);
        }
        
    }
    
    public final String getName() {
        return name;
    }

    public ServiceResult getResult() throws RemoteException {
        return result;
    }
    
    
    
    

}
