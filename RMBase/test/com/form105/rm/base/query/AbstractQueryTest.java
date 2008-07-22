package com.form105.rm.base.query;

import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.config.SimpleClientConfiguration;
import net.form105.rm.base.container.RMIQueryHandlerContainer;
import net.form105.rm.base.query.RMIQueryHandler;

import org.apache.log4j.Logger;
import org.junit.Before;

public class AbstractQueryTest {
	
	public static Logger logger = Logger.getLogger(AbstractQueryTest.class);
	
	RMIQueryHandlerContainer queryContainer;
	
	@Before
	public void setUp() throws Exception {
		logger.info("Configure Container and start ...");
		ContainerConfiguration configuration = new ContainerConfiguration(new SimpleClientConfiguration());
        Container.getInstance().load(configuration);
        
        queryContainer = (RMIQueryHandlerContainer) Container.getContainer().getComponent(RMIQueryHandlerContainer.class);
        
	}
	
	protected RMIQueryHandler<Void> getQueryHandler() {
		return queryContainer.getQueryHandler();
	}
	
	

}
