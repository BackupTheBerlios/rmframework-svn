package net.form105.web.base.container;

import java.io.File;
import java.io.IOException;

import net.form105.rm.base.container.AbstractContainer;

import org.apache.log4j.Logger;
import org.apache.wicket.protocol.http.WicketServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceCollection;


public class EmbeddedWebContainer extends AbstractContainer {
	
	public static Logger logger = Logger.getLogger(EmbeddedWebContainer.class);
	
	private final String configFilename = "jetty-config.xml";
	private Server server;
	

	@Override
	public void start() {
		
		
		
		//String configPath = Container.getInstance().getConfiguration().getConfigurationDirectory();
		//String defaultConfigFile = configPath + configFilename;
		
		Server server = new Server(8080);
		
		ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
		
		ServletHolder servletHolder = new ServletHolder(new WicketServlet());
		servletHolder.setInitParameter("applicationClassName", "net.form105.web.base.Application");
		servletHolder.setInitOrder(1);
		
		try {
			
			logger.info(new File("./resource").getCanonicalPath());
			context.newResource("./resources");
			
			ResourceCollection collection = new ResourceCollection(new Resource[] {Resource.newResource("./resources")});
			context.setBaseResource(collection);	
				
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		context.addServlet(servletHolder, "/*");
		try {
			server.start();
			//server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		/*SelectChannelConnector connectorDefault = new SelectChannelConnector();
		connectorDefault.setPort(8080);
		connectorDefault.setMaxIdleTime(30000);
		connectorDefault.setRequestHeaderSize(8192);
		
		server.addConnector(connectorDefault);*/
		
	}

	@Override
	public void stop() {
		if (server.isRunning()) {
			try {
				server.stop();
			} catch (Exception e) {
				logger.error("Can't stop server. Exception occured!", e);
			}
		}
		
	}

}
