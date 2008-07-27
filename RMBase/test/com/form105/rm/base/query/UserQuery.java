package com.form105.rm.base.query;


import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.FilterQuery;
import net.form105.rm.base.query.RMIQueryHandler;
import net.form105.rm.selection.UserSelection;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

public class UserQuery extends AbstractRemoteTest{
	
	public static Logger logger = Logger.getLogger(UserQuery.class);


	@After
	public void tearDown() throws Exception {
		logger.info("tear down");
	}
	
	@Test
	public void getUsers() {
		
		UserSelection selection = new UserSelection();
		
		
		
		
		FilterQuery<User> query = new FilterQuery(selection);
		
		doQuery(query);
		
	}

}
