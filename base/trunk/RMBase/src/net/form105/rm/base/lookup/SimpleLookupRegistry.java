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
public class SimpleLookupRegistry<T> implements ILookup<T> {

    private Logger logger = Logger.getLogger(SimpleLookupRegistry.class);

    private Map<Class<?>, IEntry<T>> registry = new HashMap<Class<?>, IEntry<T>>();

    @Override
    public <I> void removeContentObject(Class<I> clazz, T object) {
        IEntry<T> entry = registry.get(clazz);
        entry.removeItem(object);
    }

    @Override
    public <I> void addContentObject(Class<I> clazz, T object) {
        IEntry<T> entry;
        if (registry.get(clazz) == null) {
            entry = createDefaultEntry();
            registry.put(clazz, entry);
        } else {
            entry = registry.get(clazz);
        }
        entry.addItem(object);
    }

    @Override
    public <I> T getFirstContentObject(Class<I> clazz) {
        if (registry.get(clazz) == null) {
            throw new RMException(new BaseI18NMessage(), "exception.lookup.noEntry", new String[] {clazz.getName()});
        } else {
            T object = registry.get(clazz).getFirstItem();
            return object;
        }
    }

    @Override
    public <I> void addEntry(Class<I> clazz, IEntry<T> entry) {
        registry.put(clazz, entry);
    }

    @Override
    public <I> IEntry<T> getEntry(Class<I> clazz) {
        return registry.get(clazz);
    }

    @Override
    public <I> List<T> getEntryAsList(Class<I> clazz) {
        IEntry<T> entry = registry.get(clazz);
        return entry.getItems();
    }

    @Override
    public <I> void removeEntry(Class<I> clazz) {
        registry.remove(clazz);
    }
    
    private IEntry<T> createDefaultEntry() {
        SimpleLookupEntry<T> entry = new SimpleLookupEntry<T>();
        return entry;
    }

}
