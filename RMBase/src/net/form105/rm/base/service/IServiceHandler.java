/*
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.service;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IServiceHandler extends Remote {
    
    public void executeService(IService service) throws RemoteException;
    
    public IResult getResult() throws RemoteException;

}
