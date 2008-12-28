/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.container;

import java.io.Serializable;

import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.lookup.EntryLookupRegistry;
import net.form105.rm.base.lookup.ILookup;

/**
 *
 * @author heiko
 */
public class GlobalLookupContainer extends AbstractContainer {
    
    ILookup registry;
    EntryLookupRegistry<IBasicDao<?, ?>> daoRegistry = new EntryLookupRegistry<IBasicDao<?, ? extends Serializable>>();
    
    public GlobalLookupContainer() {
    	super();
    }
    
    public void start() {
        registry = new EntryLookupRegistry();
    }

    public void stop() {
        
    }
    
    public ILookup getLookupRegistry() {
        return registry;
    }

}
