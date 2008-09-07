package net.form105.rm.base.dao.db;

/**
 * A dbSelector to use if only one database is at the backend of the server. Therefor
 * a default name is provided.
 * @author heiko
 *
 */
public class SingleDBSelector implements IDbSelector {
	
	private final String dbName = "default.dbo";

	@Override
	public String getDBFilename() {
		return dbName;
	}

}
