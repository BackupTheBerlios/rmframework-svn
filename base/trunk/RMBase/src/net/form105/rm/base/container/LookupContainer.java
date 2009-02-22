/*
 * LookupContainer.java
 * 
 * Copyright (c) 2009, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.container;

import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.lookup.SimpleLookupRegistry;

/**
 *
 * @author heiko
 */
public class LookupContainer extends AbstractContainer {
    
    private ILookup globalRegistry;
    private SimpleLookupRegistry daoRegistry;
    
    public LookupContainer() {
    	super();
    }
    
    public void start() {
        globalRegistry = new SimpleLookupRegistry();
        daoRegistry = new SimpleLookupRegistry();
    }

    public void stop() {
        
    }
    
    public ILookup getGlobalLookup() {
        return globalRegistry;
    }
    
    public ILookup getDaoLookup() {
        return daoRegistry;
    }

}
