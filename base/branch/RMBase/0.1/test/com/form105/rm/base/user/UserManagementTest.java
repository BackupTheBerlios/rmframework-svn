package com.form105.rm.base.user;

import static junit.framework.Assert.assertTrue;

import java.util.Collection;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.DefaultFilterQuery;
import net.form105.rm.base.query.FindAllDaoQuery;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.server.filter.other.UserAuthorizationFilter;
import net.form105.rm.server.selection.UserSelection;
import net.form105.rm.server.service.CreateUserService;
import net.form105.rm.server.service.DeleteUserService;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class UserManagementTest extends AbstractRemoteTest<User> {

	public static Logger logger = Logger.getLogger(UserManagementTest.class);
	

	public void addUser() {
		// check if user exist
		FindAllDaoQuery<User> query = new FindAllDaoQuery<User>(XMLUserObjectDAO.class);
		IResult<User> userResult = doQuery(query);
		Collection<User> users = userResult.getResultList();
		// if user already exist delete it first
		for (User user : users) {
			if (user.getId().equals(9999L)) {
				logger.info("Before adding a user: delete the already existing user");
				deleteUser();
			}
		}
		
		logger.info("Test: Adding user with id = 9999");
		CreateUserService service = new CreateUserService();
		CreateUserService.ServiceArgument arg = service.getArgument();
		User user = new User();
		user.setEMail("testuser@company.org");
		user.setFirstName("firstName");
		user.setSirName("name");
		user.setShortName("dummyYummy");
		user.setId(9999L);
		user.setPassword("12345");
		arg.user = user;
		IResult<User> result = doService(service);
		assertTrue(result.getStatus() == ResultStatus.SUCCESS);
		result = doService(service);
		logger.info("Test: Adding user with id = 9999 again with failed result");
		assertTrue(result.getStatus() == ResultStatus.FAIL);
	}


	public void getUsers() {
		logger.info("Test: Getting user");
		FindAllDaoQuery<User> query = new FindAllDaoQuery<User>(XMLUserObjectDAO.class);
		IResult<User> result = doQuery(query);
		Collection<User> users = result.getResultList();
		if (users != null) {
			logger.info("Found users: #"+users.size());
			for (User user : users) {
				if (user.getId().equals(9999L)) {
					logger.info("Test: Found user with id = 9999");
					assertTrue(true);
				}
			}
		}
		assertTrue(users.size() > 0);
	}
	

	public void authenticateUser() {
		
		addUser();
		
		UserAuthorizationFilter<User> filter = new UserAuthorizationFilter<User>(9999L, "12345");
		DefaultFilterQuery<User> query = new DefaultFilterQuery<User>(new UserSelection(), filter);
		IResult<User> result = doQuery(query);
		logger.info("Test: Authenticate user, found #"+result.getResultList().size());
		assertTrue(result.getResultList().size() > 0);
		
		// Try to authenticate with a wrong password
		filter = new UserAuthorizationFilter<User>(9999L, "11111");
		query = new DefaultFilterQuery<User>(new UserSelection(), filter);
		result = doQuery(query);
		assertTrue(result.getResultList().size() == 0);
		
	}
	

	public void deleteUser() {
		logger.info("Test: Deleting user with id = 9999");
		DeleteUserService service = new DeleteUserService();
		DeleteUserService.ServiceArgument arg = service.getArgument();
		arg.id = 9999L;
		IResult<User> result = doService(service);
		assertTrue(result.getStatus() == ResultStatus.SUCCESS);
		
		logger.info("Test: Deleting user with id = 9999 again with failed result");
		result = doService(service);
		assertTrue(result.getStatus() == ResultStatus.FAIL);
		logger.info(result.getException());
	}
	
	@Test 
	public void testUser() {
		addUser();
		getUsers();
		authenticateUser();
		deleteUser();
		
		
	}
	
	
}
