/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.container;

import com.form105.rm.base.lookup.EntryLookupRegistry;
import org.picocontainer.Startable;

/**
 *
 * @author heiko
 */
public class GlobalLookupContainer extends AbstractContainer implements Startable {
    
    EntryLookupRegistry registry;
    
    public void start() {
        logger.info("Start GlobalLookupContainer");
        registry = new EntryLookupRegistry();
    }

    public void stop() {
        
    }
    
    public EntryLookupRegistry getLookupRegistry() {
        return registry;
    }

}
