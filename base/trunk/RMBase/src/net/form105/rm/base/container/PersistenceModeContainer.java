/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.container;

import net.form105.rm.base.dao.db.IDbSelector;
import net.form105.rm.base.dao.db.SingleDBSelector;
import net.form105.rm.base.dao.resource.AbstractResourceDao;
import net.form105.rm.base.dao.resource.ResourceDb4oDao;
import net.form105.rm.base.dao.resource.ResourceMapDao;
import net.form105.rm.base.helper.ExceptionHelper;

import org.picocontainer.Disposable;
import org.picocontainer.Startable;

/**
 * The DBContainer initializes the database by generating a dbSelector. The
 * selector creates the db object instance to access the database. Dependent of
 * the server mode a selector will be chosen.
 * 
 * Property: server.db4o.defaultPath A default file for a single db instance
 * 
 * TODO: use a db path configuration and a default file name property
 * 
 * @author hk
 * 
 */
public class PersistenceModeContainer extends AbstractContainer implements Startable, Disposable {

	private String DBO_FILE_PROPERTY = "server.db4o.defaultPath";
	private ModeContainer modeContainer;
	private LookupContainer lookupContainer;
	private IDbSelector dbSelector;

	PropertiesContainer properties;

	public PersistenceModeContainer(PropertiesContainer properties, ModeContainer mode,
			LookupContainer lookupContainer) {
		super();
		this.properties = properties;
		this.modeContainer = mode;
		this.lookupContainer = lookupContainer;

	}

	public void start() {
		logger.info("Starting: PersistenceModeContainer");
		validate();

		String dboFile;

		switch (modeContainer.getCurrentMode()) {
		case DBSingle:
			dboFile = properties.getProperty(DBO_FILE_PROPERTY);
			dbSelector = new SingleDBSelector(dboFile);
			provideDbSingleMode();
			break;

		case DUAL:
			dboFile = properties.getProperty(DBO_FILE_PROPERTY);
			dbSelector = new SingleDBSelector(dboFile);
			provideDualMode();
			break;

		case MEMORY:
			provideMemoryMode();

		default:
			break;
		}

	}

	public void stop() {

	}

	public void dispose() {

	}

	/**
	 * The database selector which is configured at startup
	 * 
	 * @return
	 */
	public IDbSelector getDBSelector() {
		return dbSelector;
	}

	public boolean supported() {
		return modeContainer.getCurrentMode().getDbSupport();
	}

	public void validate() {
		if (properties.getProperty(DBO_FILE_PROPERTY) == null) {
			ExceptionHelper.throwBaseException("exception.server.propertyNotExist", new String[] { DBO_FILE_PROPERTY });
		}
	}

	/**
	 * Register the db and map dao whereby the map dao is registered in the db
	 * dao as the transient dao
	 */
	private void provideDualMode() {
		// register resource daos
		ResourceMapDao resourceMapDao = new ResourceMapDao();
		ResourceDb4oDao resourceDbDao = new ResourceDb4oDao(resourceMapDao);
		lookupContainer.getDaoLookup().addEntry(AbstractResourceDao.class, resourceMapDao);
		lookupContainer.getDaoLookup().addEntry(AbstractResourceDao.class, resourceDbDao);
	}

	/**
	 * In db single mode register the
	 */
	private void provideDbSingleMode() {
		ResourceDb4oDao resourceDbDao = new ResourceDb4oDao();
		lookupContainer.getDaoLookup().addEntry(AbstractResourceDao.class, resourceDbDao);
	}

	private void provideMemoryMode() {
		ResourceMapDao resourceMapDao = new ResourceMapDao();
		lookupContainer.getDaoLookup().addEntry(AbstractResourceDao.class, resourceMapDao);
	}

}
