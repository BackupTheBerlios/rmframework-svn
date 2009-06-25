/*
 * Copyright (c) 2006 Kaiser technology AG Nordringstrasse 9 4702
 * Oensingen
 * 
 * All rights reserved.
 * 
 */
package net.form105.rm.base.message;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * Object CommandKey contains all keys to identify a Command
 * 
 * @author J.Drollinger
 */
public class KeyPair implements Serializable {

	public static Logger logger = Logger.getLogger(KeyPair.class);

	private String key1;

	private String key2;

	public KeyPair(String key1, String key2) {
		this.key1 = key1;
		this.key2 = key2;
	}

	/**
	 * returns the key1
	 * 
	 * @return String
	 */
	public String getKey1() {
		return key1;
	}

	/**
	 * sets the key1
	 * 
	 * @param key1
	 */
	public void setKey1(String key1) {
		this.key1 = key1;
	}

	/**
	 * returns the key2
	 * 
	 * @return
	 */
	public String getKey2() {
		return key2;
	}

	/**
	 * sets the key2
	 * 
	 * @param key2
	 */
	public void setKey2(String key2) {
		this.key2 = key2;
	}

	/**
	 * equals compares both keys
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof KeyPair) {
			KeyPair keyO = (KeyPair) o;
			return (key1.equals(keyO.getKey1()) && key2.equals(keyO.getKey2()));
		}
		return false;
	}

	/**
	 * hashCode to find this CommandKey
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int hashCode = ((37 * key1.hashCode()) ^ key2.hashCode());
		return hashCode;
	}

	/**
	 * Returns a String representation of the command key in the form key1 - key2
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return key1 + " - " + key2;
	}

}
