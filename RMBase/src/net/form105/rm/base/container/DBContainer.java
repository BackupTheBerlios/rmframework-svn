/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.container;


import net.form105.rm.base.dao.db.IDbSelector;
import net.form105.rm.base.dao.db.SingleDBSelector;

import org.picocontainer.Disposable;
import org.picocontainer.Startable;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

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
		
		if (modeContainer.getCurrentMode() == ModeContainer.Mode.DBSingle) {
			dbSelector = new SingleDBSelector();
		}
	}
  

  public void start() {
	  logger.info("Starting: DBContainer");
	  if (modeContainer.getCurrentMode() == ModeContainer.Mode.DBSingle) {
		  // register dao with single database selector
	  }
  }

  public void stop() {
    
  }

  public void dispose() {
    
  }
  
  public void startDb4o() {
	  String dboFile = properties.getProperty(DBO_FILE_PROPERTY);
	  db=Db4o.openFile(dboFile);
  }
  
  public ObjectContainer getDb() {
	  return db;
  }
  
  /**
   * The database selector which is configured at startup
   * @return
   */
  public IDbSelector getDBSelector() {
	  return dbSelector;
  }
  

}
