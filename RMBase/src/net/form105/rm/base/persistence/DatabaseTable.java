package net.form105.rm.base.persistence;

import java.io.Serializable;

/**
 * Holds informations for database tables. This class is intended to use after
 * queries to a database have been submitted.
 * @author heikok
 *
 */
public class DatabaseTable implements Serializable {
	
	private String tableName;
	private boolean exists;
	public boolean getExists() {
		return exists;
	}
	public void setExists(boolean exists) {
		this.exists = exists;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	

}
