/*
 * RMException.java, Oct 13, 2007, 11:24:35 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.exception;

import net.form105.rm.server.i18n.IMessage;


public class RMException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public RMException(String defaultMessage) {
        super(defaultMessage);
    }

    public RMException(String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
    }
    
    public RMException(IMessage message, String key, String[] params, Throwable cause) {
    	super(message.getMessage(key, params), cause);
    }
    
    public RMException(IMessage message, String key, String[] params) {
    	super(message.getMessage(key, params));
    }
}
