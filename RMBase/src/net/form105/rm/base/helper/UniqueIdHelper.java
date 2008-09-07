package net.form105.rm.base.helper;

public class UniqueIdHelper {
	
	public static synchronized Long getId() {
		return System.currentTimeMillis();
	}

}
