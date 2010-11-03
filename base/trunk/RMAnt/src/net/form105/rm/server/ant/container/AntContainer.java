package net.form105.rm.server.ant.container;

import java.io.File;

import net.form105.rm.base.Container;
import net.form105.rm.base.container.AbstractContainer;
import net.form105.rm.base.container.PropertiesContainer;
import net.form105.rm.server.ant.hotfolder.HotfolderConfig;

import org.apache.log4j.Logger;

public class AntContainer extends AbstractContainer{
	
	public static Logger logger = Logger.getLogger(AntContainer.class);
	
	private PropertiesContainer propContainer;
	
	public AntContainer(PropertiesContainer propContainer) {
		this.propContainer = propContainer;
	}

	public void start() {
		String configPath = Container.getInstance().getConfiguration().getConfigurationDirectory();
		logger.info(configPath);
		HotfolderConfig config = new HotfolderConfig(configPath + File.separator + "hotfolder.xml");
	}

	public void stop() {
		
	}

}
