package net.form105.rm.base.dao.db;

import org.apache.log4j.Logger;

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
	
	public static Logger logger = Logger.getLogger(SingleDBSelector.class);
	
	private final String USER = "db4o";
	private final String PASSWD = "db4o";
	private final String HOST = "localhost";
	// 0xdb40 = 56128
	private final int PORT = 0xdb40;

	private ObjectContainer objectContainer;

	public SingleDBSelector(String fileName) {
		// singleDb = Db4o.openFile(fileName);
		startDBServer(fileName);
	}

	@Override
	public ObjectContainer getObjectContainer() {
		
		if (objectContainer == null) {
			objectContainer = newObjectContainer();
		}
		
		return objectContainer;
	}
	
	@Override
	public ObjectContainer newObjectContainer() {
		return Db4o.openClient(HOST, PORT, USER, PASSWD);
	}

	private void startDBServer(String fileName) {
		logger.info("Open db4o file: "+fileName);
		ObjectServer server = Db4o.openServer(fileName, 0xdb40);
		server.grantAccess(USER, PASSWD);
	}

}
