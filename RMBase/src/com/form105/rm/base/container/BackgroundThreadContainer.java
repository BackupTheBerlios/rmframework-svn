/*
 * BackgroundThreadContainer.java, Oct 28, 2007, 4:58:11 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.container;


import com.form105.rm.base.BackgroundThread;
import org.apache.log4j.Logger;
import org.picocontainer.Startable;

/**
 *
 * @author heiko
 */
public class BackgroundThreadContainer extends AbstractContainer implements Startable {

  private static Logger logger = Logger.getLogger(BackgroundThreadContainer.class);
  
  BackgroundThread bgThread = new BackgroundThread();
  Thread thread;
  
  public void start() {
    
    thread = new Thread(bgThread);
    thread.start();
  }

  public void stop() {
      
    
  }

}
