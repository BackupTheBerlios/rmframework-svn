package net.form105.rm.base.helper;

import org.apache.log4j.Logger;

public class UniqueIdHelper {
	
	public static Logger logger = Logger.getLogger(UniqueIdHelper.class);
	
	public static synchronized Long getId() {
		logger.info(System.currentTimeMillis());
		return System.currentTimeMillis();
	}

}
