package net.form105.web.base;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.form105.rm.base.Container;
import com.form105.rm.base.ContainerConfiguration;
import com.form105.rm.base.IConfiguration;
import com.form105.rm.base.config.ConfigurationType;

public class WebListener implements ServletContextListener, IConfiguration {
	
	public static Logger logger = Logger.getLogger(WebListener.class);
	
	public String configurationPath;
	public String containerFile = "container.xml";
	public ContainerConfiguration configuration;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// Always create a container configuration first
		// All other system wide configuration should be loaded by a registered class
		// in the pico container
		String realPath = event.getServletContext().getRealPath("/");
		configurationPath = realPath + "WEB-INF" + File.separator + "config/";
		configuration = new ContainerConfiguration(this);
		
		// Loading pico container
		Container.getInstance().load(configuration);
		
	}

	@Override
	public String getConfigurationPath() {
		return configurationPath;
	}

	@Override
	public String getContainerFile() {
		return containerFile;
	}

	@Override
	public ConfigurationType getType() {
		return ConfigurationType.WEB;
	}

}
