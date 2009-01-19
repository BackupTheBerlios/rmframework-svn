/*
 * LookupContainer.java
 * 
 * Copyright (c) 2009, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.container;

import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.lookup.SimpleLookupRegistry;
import net.form105.rm.base.model.AgentObject;

/**
 *
 * @author heiko
 */
public class LookupContainer extends AbstractContainer {
    
    private ILookup<?> globalRegistry;
    private SimpleLookupRegistry<AbstractAgentObjectDao<?>> daoRegistry;
    
    public LookupContainer() {
    	super();
    }
    
    public void start() {
        globalRegistry = new SimpleLookupRegistry<Object>();
        daoRegistry = new SimpleLookupRegistry<AbstractAgentObjectDao<?>>();
    }

    public void stop() {
        
    }
    
    public ILookup<?> getGlobalLookup() {
        return globalRegistry;
    }
    
    public <T> ILookup<AbstractAgentObjectDao<? extends AgentObject>> getDaoLookup() {
        return daoRegistry;
    }

}
