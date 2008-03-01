package com.form105.rm.base.exception;

import java.util.List;

/**
 * 
 * @author Heiko Kundlacz
 */
public class TagNotFoundException extends RMException {

    public TagNotFoundException(String defaultMessage) {
        super(defaultMessage);
    }
    
    public TagNotFoundException(String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
    }

    public TagNotFoundException(String defaultMessage, String messageKey, List<String> properties) {
        super(defaultMessage, messageKey, properties);
    }
}
