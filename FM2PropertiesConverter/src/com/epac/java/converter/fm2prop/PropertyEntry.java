package com.epac.java.converter.fm2prop;

/**
 * Represents an entry in the 
 * @author heikok
 *
 */

public class PropertyEntry {
	
	private String section;
	private String key;
	private String value;
	
	
	public PropertyEntry(String section, String key, String value) {
		this.section = section;
		this.key = key;
		this.value = value;
	}
	
	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	public String toPropertyString() {
		return key + "=" + value;
	}
}
