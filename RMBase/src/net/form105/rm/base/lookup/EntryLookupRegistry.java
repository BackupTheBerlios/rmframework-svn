/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.lookup;

import java.util.ArrayList;
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
public class EntryLookupRegistry implements ILookup {
    
    private Logger logger = Logger.getLogger(EntryLookupRegistry.class);
    private Map<Class<?>, IEntry> registry = new HashMap<Class<?>, IEntry>();
    
    /* (non-Javadoc)
	 * @see net.form105.rm.base.lookup.ILookup#addEntry(java.lang.Class, java.lang.Object)
	 */
    public void addEntry(Class<?> clazz, Object object) {
        IEntry entry;
        if (registry.get(clazz) == null) {
            entry = createDefaultEntry();
            entry.addItem(object);
            registry.put(clazz, entry);
        } else {
            entry = registry.get(clazz);
            entry.addItem(object);
        }

    }
    
    /* (non-Javadoc)
	 * @see net.form105.rm.base.lookup.ILookup#getEntry(java.lang.Class)
	 */
    public IEntry getEntry(Class<?> clazz) {
        if (registry.get(clazz) == null) {
            return createDefaultEntry();
        } else {
            return registry.get(clazz);
        }
    }
    
    /* (non-Javadoc)
	 * @see net.form105.rm.base.lookup.ILookup#getEntryAsList(java.lang.Class)
	 */
    public List<?> getEntryAsList(Class<?> clazz) {
    	IEntry entry = registry.get(clazz);
    	if (entry == null) {
    		return new ArrayList();
    	}
    	return entry.getItems();
    }
    
    public IEntry createDefaultEntry() {
        return new SimpleLookupEntry();
    }
    
    /* (non-Javadoc)
	 * @see net.form105.rm.base.lookup.ILookup#getContent(java.lang.Class)
	 */
    public Object getContent(Class<?> clazz) {
    	if (registry.get(clazz) == null) {
    		logger.error("No object is registered with class: "+clazz.getSimpleName());
    		return null;
    	} else {
    		Object object = registry.get(clazz).getFirstItem();
    		return object;
    	}
    }
    
    /* (non-Javadoc)
	 * @see net.form105.rm.base.lookup.ILookup#removeEntry(java.lang.Class)
	 */
    public void removeEntry(Class<?> clazz) {
    	registry.remove(clazz);
    }

}
