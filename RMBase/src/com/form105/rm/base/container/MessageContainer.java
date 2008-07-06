/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.container;

import com.form105.rm.base.lookup.EntryLookupRegistry;
import com.form105.rm.i18n.ExceptionMessage;
import org.picocontainer.Startable;

/**
 *
 * @author heiko
 */
public class MessageContainer extends AbstractContainer implements Startable {
    
    private EntryLookupRegistry lookup;
    private GlobalLookupContainer lookupContainer;
    
    public MessageContainer(GlobalLookupContainer lookupContainer) {
        this.lookupContainer = lookupContainer;
    }

    public void start() {
        logger.info("Start MessageContainer");
        lookup = lookupContainer.getLookupRegistry();
        ExceptionMessage exMessage = new ExceptionMessage();
        lookup.addEntry(exMessage.getClass(), exMessage);
    }

    public void stop() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}