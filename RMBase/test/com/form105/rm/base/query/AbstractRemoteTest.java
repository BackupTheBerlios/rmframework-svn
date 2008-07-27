package com.form105.rm.base.query;

import java.rmi.RemoteException;

import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.config.SimpleClientConfiguration;
import net.form105.rm.base.container.RMIClientContainer;
import net.form105.rm.base.query.IQuery;
import net.form105.rm.base.query.IQueryHandler;
import net.form105.rm.base.service.IService;
import net.form105.rm.base.service.IServiceHandler;

import org.apache.log4j.Logger;

public class AbstractRemoteTest {
	
	public static Logger logger = Logger.getLogger(AbstractRemoteTest.class);
	
	RMIClientContainer clientContainer;
	
	public AbstractRemoteTest() {
		logger.info("Configure Container and start ...");
		ContainerConfiguration configuration = new ContainerConfiguration(new SimpleClientConfiguration());
        Container.getInstance().load(configuration);
        
        clientContainer = (RMIClientContainer) Container.getContainer().getComponent(RMIClientContainer.class);
	}
	

	
	protected IQueryHandler getQueryHandler() {
		return clientContainer.getQueryHandler();
	}
	
	protected IServiceHandler getServiceHandler() {
		return clientContainer.getServiceHandler();
	}
	
	protected void doService(IService service) {
		try {
			getServiceHandler().executeService(service);
		} catch (RemoteException re) {
			logger.error(re, re);
		}
	}
	
	protected void doQuery(IQuery query) {
		try {
			getQueryHandler().executeQuery(query);
		} catch (RemoteException re) {
			logger.error(re, re);
		}
	}
	
	

}
