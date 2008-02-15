/*
 * Agent.java, Oct 21, 2007, 9:14:38 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base;

import com.form105.rm.base.helper.ImageHelper;

/**
 *
 * @author heiko
 */
public class Agent {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Container.getInstance();
    
    ImageHelper helper = new ImageHelper();
    helper.loadImageData();
    
    
  }

  
}