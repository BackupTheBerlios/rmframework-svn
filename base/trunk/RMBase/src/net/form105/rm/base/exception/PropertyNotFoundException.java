package net.form105.rm.base.exception;

import net.form105.rm.base.i18n.I18nMessage;



/**
 * An exception to use if a system or local property can't be found
 * @author heiko
 *
 */
public class PropertyNotFoundException extends RMException {

    private static final long serialVersionUID = 1L;

    
    public PropertyNotFoundException(I18nMessage message, String key, String[] params) {
        super(message, key, params);
        
    }
    
	
}
