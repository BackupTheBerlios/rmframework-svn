package net.form105.rm.base.dao.db;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

/**
 * A dbSelector to use if only one database is at the backend of the server. Therefor
 * a default name is provided.
 * @author heiko
 *
 */
public class SingleDBSelector implements IDbSelector {
	
	private final ObjectContainer singleDb;
	
	public SingleDBSelector(String fileName) {
		singleDb=Db4o.openFile(fileName);
	}

	@Override
	public ObjectContainer getDbInstance() {
		return singleDb;
	}

}
