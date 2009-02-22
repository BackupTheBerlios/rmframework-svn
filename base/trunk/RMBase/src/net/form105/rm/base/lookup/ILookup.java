package net.form105.rm.base.lookup;

import java.util.List;

public interface ILookup {
    
    public abstract void removeContentObject(Class<?> clazz, Object Object);
    
    public abstract void addContentObject(Class<?> clazz, Object object);
    
    /**
     * Returns the first object of the entry which includes a list
     * @param clazz
     * @return
     */
    public abstract Object getFirstContentObject(Class<?> clazz);

    /**
     * Add an object to the registry by its class
     * @param clazz
     * @param object
     */
    public abstract void addEntry(Class<?> clazz, IEntry entry);

    /**
         * Removes an entry from the registry
         * @param clazz
         */
    public abstract void removeEntry(Class<?> clazz);

    /**
     * Get an entry by its class. 
     * @param clazz
     * @return The entry which holds a list of objects
     */
    public abstract IEntry getEntry(Class<?> clazz);

    public abstract List<?> getEntryAsList(Class<?> clazz);

    

}