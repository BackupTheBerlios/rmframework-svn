/*
 * BackgroundThreadContainer.java, Oct 28, 2007, 4:58:11 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.container;


import org.apache.log4j.Logger;
import org.picocontainer.Disposable;
import org.picocontainer.Startable;

/**
 *
 * @author heiko
 */
public class BackgroundThreadContainer implements Startable, Disposable {

  private static Logger logger = Logger.getLogger(BackgroundThreadContainer.class);
  
  private boolean started = true;
  
  public void start() {
    while (started) {
      try {
        Thread.sleep(Long.MAX_VALUE);
      } catch (InterruptedException ex) {
        logger.info(ex, ex);
      }
    }
  }

  public void stop() {
    
  }

  public void dispose() {
   
  }

}
