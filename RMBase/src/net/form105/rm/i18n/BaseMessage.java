package net.form105.rm.i18n;

import java.util.ResourceBundle;

/**
 * Handles all messages that a basic to the rm framework. Normally all
 * information messages that should be internationalized are base messages.
 * @author heiko
 */
public class BaseMessage extends AbstractMessage {
    
    private final static ResourceBundle bundle = ResourceBundle.getBundle("BaseMessage");

    @Override
    public ResourceBundle getBundle() {
        return BaseMessage.bundle;
    }
    
    

}
