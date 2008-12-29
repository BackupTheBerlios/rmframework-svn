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
public class LookupContainer extends AbstractContainer {
    
    private ILookup<?> globalRegistry;
    private EntryLookupRegistry<IBasicDao<?,?>> daoRegistry = new EntryLookupRegistry<IBasicDao<?,?>>();
    
    public LookupContainer() {
    	super();
    }
    
    public void start() {
        globalRegistry = new EntryLookupRegistry();
    }

    public void stop() {
        
    }
    
    public ILookup<?> getGlobalLookup() {
        return globalRegistry;
    }
    
    public ILookup<IBasicDao<?,?>> getDaoLookup() {
        return daoRegistry;
    }

}
