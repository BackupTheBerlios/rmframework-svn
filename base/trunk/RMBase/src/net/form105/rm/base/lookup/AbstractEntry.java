package net.form105.rm.base.lookup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.form105.rm.base.exception.RMException;

/**
 *
 * @author hk
 */
public class AbstractEntry implements IEntry {

    public Set<ILookupListener> listeners = Collections.synchronizedSet(new HashSet<ILookupListener>());
    public List<Object> lookupItems = Collections.synchronizedList(new ArrayList<Object>());

    public List<Object> getItems() {
        return lookupItems;
    }
    
    public Object getFirstItem() {
        if (lookupItems.size() == 0) {
            throw new RMException("Entry list size is 0");
        } else {
            return lookupItems.get(0);
        }
    }

    public void addListener(ILookupListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ILookupListener listener) {
        listeners.remove(listener);
    }

    public void updateItem(Object object) {
        removeItem(object);
        addItem(object);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.updateItem(object);
            }
        }
    }

    public void updateItems(List<Object> list) {
        removeItems(list);
        addItems(list);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.updateItems(list);
            }
        }
    }

    public void removeItem(Object object) {
        lookupItems.remove(object);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.removeItem(object);
            }
        }
    }

    public void removeItems(List<Object> list) {
        lookupItems.removeAll(list);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.removeItems(list);
            }
        }
    }

    public void addItem(Object object) {
        lookupItems.add(object);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.addItem(object);
            }
        }
    }

    public void addItems(List<Object> list) {
        lookupItems.addAll(list);
        if (listeners.size() > 0) {
            for (ILookupListener listener : listeners) {
                listener.addItems(list);
            }
        }
    }
}
