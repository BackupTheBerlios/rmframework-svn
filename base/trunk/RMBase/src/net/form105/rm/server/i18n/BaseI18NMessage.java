package net.form105.rm.server.i18n;

import java.util.ResourceBundle;

/**
 * Handles all messages that a basic to the rm framework. Normally all
 * information messages that should be internationalized are base messages.
 * @author heiko
 */
public class BaseI18NMessage extends AbstractMessage {
    
    private final static ResourceBundle bundle = ResourceBundle.getBundle("i18n/BaseMessage");

    @Override
    public ResourceBundle getBundle() {
        return BaseI18NMessage.bundle;
    }
    
    

}
