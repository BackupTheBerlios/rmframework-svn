package net.form105.rm.base.dao.db;

import com.db4o.ObjectContainer;

/**
 * Represents the db which the DAOs should access to.
 * @author heiko
 *
 */
public interface IDbSelector {
	
	public ObjectContainer getDbInstance();

}
