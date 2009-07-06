/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.container;

import java.util.HashMap;

import net.form105.rm.base.command.CommandHandler;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.dao.resource.ResourceDb4oDao;
import net.form105.rm.base.dao.resource.ResourceMapDao;
import net.form105.rm.base.helper.ExceptionHelper;
import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.Resource;
import net.form105.rm.server.command.LoadXmlModelCommand;

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
	
	private HashMap<Class<? extends AgentObject>, IBasicDao<? extends AgentObject>> daoMap = new HashMap<Class<? extends AgentObject>, IBasicDao<? extends AgentObject>>();

	private String DBO_FILE_PROPERTY = "server.db4o.defaultPath";
	private ModeContainer modeContainer;

	private PropertiesContainer properties;
	private Db4oContainer db4oContainer;

	public PersistenceModeContainer(PropertiesContainer properties, ModeContainer mode, Db4oContainer db4oContainer) {
		super();
		this.properties = properties;
		this.modeContainer = mode;
		this.db4oContainer = db4oContainer;

	}

	public void start() {
		logger.info("Starting: PersistenceModeContainer");
		validate();


		switch (modeContainer.getCurrentMode()) {
		case DBSINGLE:
			provideDbSingleMode();
			break;

		case DUAL:
			provideDualMode();
			break;

		case MEMORY:
			provideMemoryMode();

		default:
		    logger.info("Running Agent in persistence mode: "+modeContainer.getCurrentMode());
			break;
		}

	}

	public void stop() {
		logger.info("Stopping container: "+getClass().getCanonicalName());
	}

	public void dispose() {

	}

	

	public boolean supported() {
		return modeContainer.getCurrentMode().hasDbSupport();
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
		ResourceDb4oDao resourceDbDao = new ResourceDb4oDao(resourceMapDao, db4oContainer.getDb4oContainer());
		
		addDao(Resource.class, resourceDbDao);
	}

	/**
	 * In db single mode register the
	 */
	private void provideDbSingleMode() {
		ResourceDb4oDao resourceDbDao = new ResourceDb4oDao(db4oContainer.getDb4oContainer());
		addDao(Resource.class, resourceDbDao);
	}

	private void provideMemoryMode() {
		ResourceMapDao resourceMapDao = new ResourceMapDao();
		addDao(Resource.class, resourceMapDao);
		// in memory mode we load all the core objects to the maps 
		LoadXmlModelCommand loadCommand = new LoadXmlModelCommand();
		CommandHandler cHandler = new CommandHandler();
		cHandler.execute(loadCommand);
	}
	
	public void addDao(Class<? extends AgentObject> clazz, IBasicDao<? extends AgentObject> dao) {
        daoMap.put(clazz, dao);
    }
    
    public IBasicDao<? extends AgentObject> getDao(Class<? extends AgentObject> clazz) {
        return daoMap.get(clazz);
    }
    
    public IBasicDao<Resource> getResourceDao() {
        IBasicDao<Resource> resourceDao = (IBasicDao<Resource>) daoMap.get(Resource.class);
        return resourceDao;
    }

}
