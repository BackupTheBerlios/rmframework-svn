/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.container;

import net.form105.rm.base.lookup.EntryLookupRegistry;

/**
 *
 * @author heiko
 */
public class GlobalLookupContainer extends AbstractContainer {
    
    EntryLookupRegistry registry;
    
    public GlobalLookupContainer() {
    	super();
    }
    
    public void start() {
        registry = new EntryLookupRegistry();
    }

    public void stop() {
        
    }
    
    public EntryLookupRegistry getLookupRegistry() {
        return registry;
    }

}