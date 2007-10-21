/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.container;


import org.apache.log4j.Logger;
import org.picocontainer.Disposable;
import org.picocontainer.Startable;
import org.picocontainer.defaults.LifecycleStrategy;

public class DBContainer implements Startable, Disposable {
  
  protected static Logger logger = Logger.getLogger(DBContainer.class);

  public void start() {
    logger.info("Starting Component");
  }

  public void stop(Object component) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void dispose(Object component) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public boolean hasLifecycle(Class type) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void stop() {
    
  }

  public void dispose() {
    
  }


}
