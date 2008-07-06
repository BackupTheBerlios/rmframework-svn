package com.form105.rm.i18n;

import java.util.ResourceBundle;

/**
 * Handles the exception messages generated in the rm framework
 * @author heiko
 */
public class ExceptionMessage extends AbstractMessage {
    
    private final ResourceBundle bundle = ResourceBundle.getBundle("ExceptionMessage");
    
    public static final String rm_exception_dao_save_resourceExist = "rm.exception.dao.save.resourceExist";
    public static final String rm_exception_lookup_emptyEntryList = "rm.exception.lookup.emptyEntryList";


    @Override
    public ResourceBundle getBundle() {
        return bundle;
    }
    
}