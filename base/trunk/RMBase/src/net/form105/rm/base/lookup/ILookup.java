package net.form105.rm.base.lookup;

import java.util.List;

public interface ILookup<T> {

	/**
	 * Add an object to the registry by its class
	 * @param clazz
	 * @param object
	 */
	public abstract void addEntry(Class<?> clazz, T object);

	/**
	 * Get an entry by its class. 
	 * @param clazz
	 * @return The entry which holds a list of objects
	 */
	public abstract IEntry<T> getEntry(Class<?> clazz);

	public abstract List<?> getEntryAsList(Class<?> clazz);

	/**
	 * Returns the first object of the entry which includes a list
	 * @param clazz
	 * @return
	 */
	public abstract T getContent(Class<?> clazz);

	/**
	 * Removes an entry from the registry
	 * @param clazz
	 */
	public abstract void removeEntry(Class<?> clazz);

}