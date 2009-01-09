package net.form105.web.base;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.config.WebConfiguration;

import org.apache.log4j.Logger;


public class WebListener extends WebConfiguration implements ServletContextListener {
	
	public static Logger logger = Logger.getLogger(WebListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("Destroying context ....");
		Container.getInstance().unload();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// Always create a container configuration first
		// All other system wide configuration should be loaded by a registered class
		// in the pico container
		String realPath = event.getServletContext().getRealPath("/");
		super.setConfigurationPath(realPath + "WEB-INF" + File.separator + "config/");
		super.setImportPath(realPath + "WEB-INF" + File.separator + "import/");
		super.setConfiguration(new ContainerConfiguration(this));
		
		// Loading pico container
		Container.getInstance().load(configuration);
		
	}

}
