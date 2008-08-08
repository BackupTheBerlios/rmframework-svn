package net.form105.rm.base.lookup;

import java.util.List;

public interface ILookup {

	/**
	 * Add an object to the registry by its class
	 * @param clazz
	 * @param object
	 */
	public abstract void addEntry(Class<?> clazz, Object object);

	/**
	 * Get an entry by its class. 
	 * @param clazz
	 * @return The entry which holds a list of objects
	 */
	public abstract IEntry getEntry(Class<?> clazz);

	public abstract List<?> getEntryAsList(Class<?> clazz);

	/**
	 * Returns the first object of the entry which includes a list
	 * @param clazz
	 * @return
	 */
	public abstract Object getContent(Class<?> clazz);

	/**
	 * Removes an entry from the registry
	 * @param clazz
	 */
	public abstract void removeEntry(Class<?> clazz);

}