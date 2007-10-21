/*
 * RMException.java, Oct 13, 2007, 11:24:35 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.helper.exception;

public class RMException extends RuntimeException {
  
  public RMException(String defaultMessage, Throwable cause) {
    super(defaultMessage, cause);
  }
  
  public RMException(String defaultMessage) {
    super(defaultMessage);
  }

}
