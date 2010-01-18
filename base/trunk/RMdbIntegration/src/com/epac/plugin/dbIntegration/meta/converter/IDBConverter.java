package com.epac.plugin.dbIntegration.meta.converter;


public interface IDBConverter {
	
	/**
	 * Converts a db column type to another or the same column type
	 * @param sourceString The string that will be converted
	 */
	public abstract String convert(String sourceString);

}
