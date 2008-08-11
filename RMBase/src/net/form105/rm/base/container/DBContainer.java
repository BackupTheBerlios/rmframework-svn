/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.container;


import org.picocontainer.Disposable;
import org.picocontainer.Startable;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class DBContainer extends AbstractContainer implements Startable, Disposable {
	
	private String DBO_FILE_PROPERTY = "server.db4o.defaultPath";
	private ObjectContainer db;
	
	PropertiesContainer properties;
	
	public DBContainer(PropertiesContainer properties) {
		super();
		this.properties = properties;
	}
  

  public void start() {
	  logger.info("Starting: DBContainer");
      startDb4o();
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
  

}
