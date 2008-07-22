package com.form105.rm.base.query;


import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.RMIQueryHandler;
import net.form105.rm.query.other.UserByIdQuery;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserQuery extends AbstractQueryTest{
	
	public static Logger logger = Logger.getLogger(UserQuery.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}


	@After
	public void tearDown() throws Exception {
		logger.info("tear down");
	}
	
	@Test
	public void getUsers() {
		
		RMIQueryHandler queryHandler = getQueryHandler();
		
		
		
		UserByIdQuery<User> query = new UserByIdQuery();
		
		queryHandler.executeQuery(query);
		
		logger.info("start test");
	}

}
