/*
 * ContainerConfiguration.java, Oct 13, 2007, 10:47:13 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.container;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.picocontainer.MutablePicoContainer;

public class ContainerConfiguration {
  
  private static Logger logger = Logger.getLogger(ContainerConfiguration.class);
  
  public void loadFromXML(MutablePicoContainer container) {
    try {
      File file = new File(".");
      logger.info(file.getCanonicalPath());
    } catch (IOException ex) {
      java.util.logging.Logger.getLogger(ContainerConfiguration.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
