package net.form105.db.cayenne.container;

import java.io.File;

import net.form105.rm.base.Container;
import net.form105.rm.base.container.AbstractContainer;
import net.form105.rm.base.container.PropertiesContainer;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.conf.Configuration;
import org.apache.cayenne.conf.FileConfiguration;

public class CayenneContainer extends AbstractContainer {

	private DataContext context;
	private PropertiesContainer props; 

	public CayenneContainer(PropertiesContainer propsContainer) {
		props = propsContainer;
	}

	public void start() {
		String configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
		String cayenneFileName = props.getProperty("db.cayenne.configFileName");
		String cayenneConfigFileName = configDir + cayenneFileName;
		FileConfiguration conf = new FileConfiguration(new File(cayenneConfigFileName));
		Configuration.initializeSharedConfiguration(conf);
		this.context = DataContext.createDataContext();
	}

	public void stop() {

	}

	/**
	 * @return the context
	 */
	public DataContext getContext() {
		return context;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	private void setContext(DataContext context) {
		this.context = context;
	}

}
