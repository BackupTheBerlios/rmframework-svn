/*
 * RMIServiceHandler.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.service;

import net.form105.rm.base.auth.AbstractIdentity;

import org.apache.log4j.Logger;

public class LocalServiceHandler<T> implements IServiceHandler {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(LocalServiceHandler.class);

	private final String name = "ServiceHandler";
	private IService service;
	private ServiceResult<T> result = new ServiceResult<T>();

	public LocalServiceHandler() {
		super();
	}

	public void executeService(IService service) {

		try {

			this.service = service;
			service.execute();
			result.setStatus(Status.SUCCESS);
		} catch (Exception ex) {
			result.setStatus(Status.FAIL);
			result.setException(ex);
			logger.error(ex);
		}

	}
	
	public void executeService(IService service, AbstractIdentity identity) {
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

	public ServiceResult<T> getResult() {
		return result;
	}

}
