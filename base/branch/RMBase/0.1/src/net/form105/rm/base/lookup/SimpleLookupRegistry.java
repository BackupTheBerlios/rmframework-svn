/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.lookup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.exception.RMException;
import net.form105.rm.server.i18n.BaseI18NMessage;

import org.apache.log4j.Logger;

/**
 * A lookup registry that is based on entities. Add an object by its class
 * and it will wrapped in an @see IEntry. The entry works as a group because
 * some objects can be placed in an entry. This allows access to a list of
 * objects.
 * @author heiko
 */
public class SimpleLookupRegistry implements ILookup {

    private Logger logger = Logger.getLogger(SimpleLookupRegistry.class);

    private Map<Class<?>, IEntry> registry = new HashMap<Class<?>, IEntry>();

    public void removeContentObject(Class<?> clazz, Object object) {
        IEntry entry = registry.get(clazz);
        entry.removeItem(object);
    }

    public void addContentObject(Class<?> clazz, Object object) {
        IEntry entry;
        if (registry.get(clazz) == null) {
            entry = createDefaultEntry();
            registry.put(clazz, entry);
        } else {
            entry = registry.get(clazz);
        }
        entry.addItem(object);
    }

    public Object getFirstContentObject(Class<?> clazz) {
        if (registry.get(clazz) == null) {
            throw new RMException(new BaseI18NMessage(), "exception.lookup.noEntry", new String[] {clazz.getName()});
        } else {
            Object object = registry.get(clazz).getFirstItem();
            return object;
        }
    }


    public void addEntry(Class clazz, IEntry entry) {
        registry.put(clazz, entry);
    }

    public IEntry getEntry(Class<?> clazz) {
        IEntry entry = registry.get(clazz);
        if (entry == null) {
            return new AbstractEntry() {};
        }
        return registry.get(clazz);
    }

    public List<?> getEntryAsList(Class<?> clazz) {
        IEntry entry = registry.get(clazz);
        if (entry == null) {
            entry = new AbstractEntry() {};
        }
        return entry.getItems();
    }

    public void removeEntry(Class<?> clazz) {
        registry.remove(clazz);
    }
    
    private IEntry createDefaultEntry() {
        SimpleLookupEntry entry = new SimpleLookupEntry();
        return entry;
    }

}
