package net.form105.rm.base.dao.db;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;

/**
 * A dbSelector to use if only one database is at the backend of the server.
 * Therefor a default name is provided.
 * 
 * @author heiko
 * 
 */
public class SingleDBSelector implements IDbSelector {

	private ObjectContainer singleDb;

	public SingleDBSelector(String fileName) {
		singleDb = Db4o.openFile(fileName);
		startDBServer(fileName);
	}

	@Override
	public ObjectContainer getDbInstance() {
		return singleDb;
	}

	public void startDBServer(String fileName) {
		ObjectServer server = Db4o.openServer(fileName, 11222);
		server.grantAccess("heiko", "heiko");
		try {
			ObjectContainer client = Db4o.openClient("localhost", 11222, "heiko", "heiko");
			// Do something with this client, or open more clients
			client.close();
		} finally {
			server.close();
		}
	}

}
