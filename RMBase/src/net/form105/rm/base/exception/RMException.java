/*
 * RMException.java, Oct 13, 2007, 11:24:35 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.exception;

import java.util.List;

public class RMException extends RuntimeException {

    private String messageKey;

    public RMException(String defaultMessage) {
        super(defaultMessage);
    }

    public RMException(String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
    }

    public RMException(String defaultMessage, String messageKey, List<String> properties) {
        super(defaultMessage);
        this.messageKey = messageKey;
    }
}
