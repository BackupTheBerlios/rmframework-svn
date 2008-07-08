/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.lookup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * A lookup registry that is based on enties. Add an object by its class
 * and it will wrapped in an @see IEntry. The entry works as a group because
 * some objects can be placed in an entry. This allows access to a list of
 * objects.
 * @author heiko
 */
public class EntryLookupRegistry {
    
    private Logger logger = Logger.getLogger(EntryLookupRegistry.class);
    private Map<Class, IEntry> registry = new HashMap<Class, IEntry>();
    
    /**
     * Add an object to the registry by its class
     * @param clazz
     * @param object
     */
    public <T> void addEntry(Class clazz, T object) {
        IEntry entry;
        if (registry.get(clazz) == null) {
            entry = createDefaultEntry();
            entry.addItem(object);
            registry.put(clazz, entry);
        } else {
            entry = registry.get(clazz);
            entry.addItem(object);
        }
        entry.addItem(object);
    }
    
    /**
     * Get an entry by its class. 
     * @param clazz
     * @return The entry which holds a list of objects
     */
    public IEntry getEntry(Class clazz) {
        if (registry.get(clazz) == null) {
            return createDefaultEntry();
        } else {
            return registry.get(clazz);
        }
    }
    
    public List getEntryAsList(Class clazz) {
    	IEntry entry = registry.get(clazz);
    	return entry.getItems();
    	
    }
    
    public IEntry createDefaultEntry() {
        return new SimpleLookupEntry();
    }
    
    /**
     * Returns the first object of the entry which includes a list
     * @param clazz
     * @return
     */
    public Object getContent(Class clazz) {
        Object object = registry.get(clazz).getFirstItem();
        return object;
    }

}
