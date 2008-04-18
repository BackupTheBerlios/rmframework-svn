package com.form105.rm.base.lookup;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author heiko
 */
public class AbstractEntry<T> implements IEntry<T> {

    public Set<ILookupListener> listeners = Collections.synchronizedSet(new HashSet<ILookupListener>());
    public Set<T> lookupItems = Collections.synchronizedSet(new HashSet<T>());

    public Set<T> getItems() {
        return lookupItems;
    }

    public void addListener(ILookupListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ILookupListener listener) {
        listeners.remove(listener);
    }

    public void updateItem(T object) {
        removeItem(object);
        addItem(object);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.updateItem(object);
            }
        }
    }

    public void updateItems(List<T> list) {
        removeItems(list);
        addItems(list);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.updateItems(list);
            }
        }
    }

    public void removeItem(T object) {
        lookupItems.remove(object);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.removeItem(object);
            }
        }
    }

    public void removeItems(List<T> list) {
        lookupItems.removeAll(list);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.removeItems(list);
            }
        }
    }

    public void addItem(T object) {
        lookupItems.add(object);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.addItem(object);
            }
        }
    }

    public void addItems(List<T> list) {
        lookupItems.addAll(list);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.addItems(list);
            }
        }
    }
}
