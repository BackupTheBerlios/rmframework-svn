package net.form105.rm.server.ant.container;

import net.form105.rm.base.container.AbstractContainer;
import net.form105.rm.base.container.PropertiesContainer;

import org.apache.log4j.Logger;

public class AntContainer extends AbstractContainer{
	
	public static Logger logger = Logger.getLogger(AntContainer.class);
	private HotfolderConfigContainer hotfolderConfig;
	
	private PropertiesContainer propContainer;
	
	public AntContainer(PropertiesContainer propContainer, HotfolderConfigContainer hotfolderConfig) {
		this.propContainer = propContainer;
		this.hotfolderConfig = hotfolderConfig;
	}

	public void start() {
		
	}

	public void stop() {
		
	}

}
