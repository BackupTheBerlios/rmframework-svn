/*
 * RMIServiceHandler.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import net.form105.rm.base.auth.AbstractIdentity;

import org.apache.log4j.Logger;

public class RMIServiceHandler extends UnicastRemoteObject implements
		IServiceHandler {

	private static final long serialVersionUID = 1L;

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
			result.setStatus(ResultStatus.SUCCESS);
		} catch (Exception ex) {
			result.setStatus(ResultStatus.FAIL);
			result.setException(ex);
			logger.error(ex, ex);
		}

	}
	
	public void executeService(IService service, AbstractIdentity identity) throws RemoteException {
		this.executeService(service);
	}

	/**
	 * The service handler will be registered in the registry by its name
	 * 
	 * @return
	 */
	public final String getName() {
		return name;
	}

	public ServiceResult getResult() throws RemoteException {
		return result;
	}

}
