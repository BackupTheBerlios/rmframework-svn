package net.form105.rm.base.lookup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author heiko
 */

/**
 * The lookup registry is a registry to save object by its class type. There isn't
 * a lazy loading mechanism. Which means that the registered objects must be 
 * instanciated before registration. 
 * The lookup registry isn't static as it should be created by a nano or 
 * picocontainer.
 * an example for usage of the key of the classregistry is a pair of daos. Where the daos
 * are registered in a list and both daos can be accessed as a group. 
 * @author heiko
 */

// TODO Use an Adapter to wrap the entry objects
public class SimpleLookupRegistry {

    private Logger logger = Logger.getLogger(SimpleLookupRegistry.class);
    private HashMap<Class, List<Object>> registry = new HashMap<Class, List<Object>>();

    
    
    /**
     * Registers an object in the lookup registry
     * @param clazz
     * @param o
     */
    public void addElement(Class clazz, Object o) {

        if (!clazz.isInstance(o)) {
            logger.error("Provided class " + clazz.getName() + " doesn't match class type of object: " + o.toString());
            return;
        }

        if (registry.get(clazz).size() > 0) {
            registry.get(clazz).add(o);
        } else {
            ArrayList list = new ArrayList();
            list.add(o);
            registry.put(clazz, list);
        }
    }

    /**
     * Add an entry to the registry. The class type of each entry in the list 
     * must match the key class
     * @param clazz The key
     * @param list The entry
     */
    public void addEntry(Class clazz, List<Object> list) {
        for (Object o : list) {
            if (!clazz.isInstance(o)) {
                logger.error("Provided class " + clazz.getName() + " doesn't match class type of object: " + o.toString());
                return;
            }
        }
    }
    
    
}
