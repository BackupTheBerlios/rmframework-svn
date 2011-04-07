package net.form105.web.base.container;

import net.form105.rm.base.container.AbstractContainer;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.WebAppContext;

import com.sun.net.ssl.internal.www.protocol.https.Handler;


public class EmbeddedWebContainer extends AbstractContainer {
	
	public static Logger logger = Logger.getLogger(EmbeddedWebContainer.class);
	
	private final String configFilename = "jetty-config.xml";
	private Server server;
	

	@Override
	public void start() {
		
		
		
		//String configPath = Container.getInstance().getConfiguration().getConfigurationDirectory();
		//String defaultConfigFile = configPath + configFilename;
		
		
		// example from org.eclipse.jetty.embedded.ManyServletContexts
		Server server = new Server(8080);
		
		//ContextHandlerCollection contexts = new ContextHandlerCollection();
        //server.setHandler(contexts);
        
        //ServletContextHandler context0 = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context0.setContextPath("/wicket");

		// Wicket
		
        

		//servletHolder.setInitParameter("applicationClassName", "net.form105.web.base.Application");
		//servletHolder.setInitOrder(1);
		
		//context0.addServlet(servletHolder,"/");
		
		
//		ServletContextHandler contextInbound = new ServletContextHandler(ServletContextHandler.SESSIONS);
//		contextInbound.setContextPath("/");
//		contextInbound.addServlet(new ServletHolder(new EomMessageServlet()), "/inbound/*");
//		contexts.setHandlers(new Handler[] {contextInbound, context0});
        System.out.println("testout");
        WebAppContext wac = new AliasEnhancedWebAppContext();
        wac.setDescriptor("./WebContent/WEB-INF/web.xml");
        wac.setContextPath("/");
        wac.setBaseResource(new ResourceCollection(new String[] {"./WebContent", "./target"}));
        wac.setResourceAlias("/WEB-INF/classes/", "/classes/");
        
        
        
        

        server.setHandler(wac);
        server.setStopAtShutdown(true);
        
		
	
			
			
			//ResourceCollection collection = new ResourceCollection(new Resource[] {Resource.newResource("./webapp")});
			//context0.setBaseResource(collection);
			//root.newResource("file://./webapp");
	
			
			
	
		
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
