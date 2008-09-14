/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.container;

import net.form105.rm.base.dao.db.IDbSelector;
import net.form105.rm.base.dao.db.SingleDBSelector;
import net.form105.rm.base.helper.ExceptionHelper;

import org.picocontainer.Disposable;
import org.picocontainer.Startable;

import com.db4o.ObjectContainer;

/**
 * The DBContainer initializes the database by generating a dbSelector. The selector 
 * creates the db object instance to access the database. Dependent of the server 
 * mode a selector will be chosen.
 * 
 * Property: server.db4o.defaultPath 
 * A default file  for a single db instance
 * 
 * TODO: use a db path configuration and a default file name property
 * 
 * @author hk
 *
 */
public class DBContainer extends AbstractContainer implements Startable, Disposable {

	private String DBO_FILE_PROPERTY = "server.db4o.defaultPath";
	private ObjectContainer db;
	private ModeContainer modeContainer;
	private IDbSelector dbSelector;

	PropertiesContainer properties;

	public DBContainer(PropertiesContainer properties, ModeContainer mode) {
		super();
		this.properties = properties;
		this.modeContainer = mode;

	}

	public void start() {
		logger.info("Starting: DBContainer");

	}

	public void stop() {
		db.close();

	}

	public void dispose() {

	}

	public void startDb4o() {
		
		validate();

		if (modeContainer.getCurrentMode() == ModeContainer.Mode.DBSingle) {
			String dboFile = properties.getProperty(DBO_FILE_PROPERTY);
			dbSelector = new SingleDBSelector(dboFile);
		}
	}

	public ObjectContainer getDb() {
		return db;
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
			ExceptionHelper.throwBaseException("exception.server.propertyNotExist", new String[] {DBO_FILE_PROPERTY});
		}
	}

}
