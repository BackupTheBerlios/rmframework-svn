/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServiceHandler extends UnicastRemoteObject implements IServiceHandler {
    
    private final String name = "ServiceHandler";
    private IService service;
    private String result = "not_executed";
    
    public RMIServiceHandler() throws RemoteException {
        super();
    }
    
    public void executeService(IService service) throws RemoteException {
        this.service = service;
        service.execute();
        result = "executed";
        
        
        
    }
    
    public final String getName() {
        return name;
    }

    public String getResult() throws RemoteException {
        return result;
    }
    
    
    
    

}
