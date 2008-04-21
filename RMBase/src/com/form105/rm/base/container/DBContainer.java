/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.container;


import org.picocontainer.Disposable;
import org.picocontainer.Startable;

public class DBContainer extends AbstractContainer implements Startable, Disposable {
  

  public void start() {
      logger.info("Start DBContainer");
      
    
  }

  public void stop() {
    
  }

  public void dispose() {
    
  }
  

}
