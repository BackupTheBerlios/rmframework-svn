package com.epac.plugin.dbIntegration.meta;

public interface IMetaColumn {

	/**
	 * The id of the column
	 * @return
	 */
	public abstract String getId();

	/**
	 * Return the type of the column
	 * @return the type
	 */
	public abstract MetaType getType();

	/**
	 * @return the notNull
	 */
	public abstract boolean isNullable();
	
	/**
	 * Return the size of the column
	 * @return size 
	 */
	public abstract int getSize(); 
	
	/**
	 * Check if size is defined
	 * @return
	 */
	public abstract boolean hasSize();

}