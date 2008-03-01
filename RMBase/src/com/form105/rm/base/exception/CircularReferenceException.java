package com.form105.rm.base.exception;

import java.util.List;

/**
 * Will be thrown if references points to themselve
 * @author Heiko Kundlacz
 *
 */
public class CircularReferenceException extends RMException {
    
    public CircularReferenceException(String defaultMessage) {
        super(defaultMessage);
    }

    public CircularReferenceException(String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
    }

    public CircularReferenceException(String defaultMessage, String messageKey, List<String> properties) {
        super(defaultMessage, messageKey, properties);



    }
}
