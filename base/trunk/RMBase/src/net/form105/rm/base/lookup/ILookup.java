package net.form105.rm.base.lookup;

import java.util.List;

public interface ILookup<V> {
    
    public abstract <I> void removeContentObject(Class<I> clazz, V Object);
    
    public abstract <I> void addContentObject(Class<I> clazz, V object);
    
    /**
     * Returns the first object of the entry which includes a list
     * @param clazz
     * @return
     */
    public abstract <I> V getFirstContentObject(Class<I> clazz);

    /**
     * Add an object to the registry by its class
     * @param clazz
     * @param object
     */
    public abstract <I> void addEntry(Class<I> clazz, IEntry<V> entry);

    /**
         * Removes an entry from the registry
         * @param clazz
         */
    public abstract <I> void removeEntry(Class<I> clazz);

    /**
     * Get an entry by its class. 
     * @param clazz
     * @return The entry which holds a list of objects
     */
    public abstract <I> IEntry<V> getEntry(Class<I> clazz);

    public abstract <I> List<V> getEntryAsList(Class<I> clazz);

    

}