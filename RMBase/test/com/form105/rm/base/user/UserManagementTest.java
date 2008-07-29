package com.form105.rm.base.user;

import static junit.framework.Assert.assertTrue;

import java.util.Collection;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.DefaultFilterQuery;
import net.form105.rm.base.query.FindAllDaoQuery;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.Status;
import net.form105.rm.server.filter.other.UserAuthorizationFilter;
import net.form105.rm.server.selection.FindAllDaoSelection;
import net.form105.rm.server.service.CreateUserService;
import net.form105.rm.server.service.DeleteUserService;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class UserManagementTest extends AbstractRemoteTest<User> {

	public static Logger logger = Logger.getLogger(UserManagementTest.class);
	
	@Test
	public void addUser() {
		// check if user exist
		FindAllDaoQuery<User> query = new FindAllDaoQuery<User>(XMLUserObjectDAO.class);
		IResult<User> userResult = doQuery(query);
		Collection<User> users = userResult.getResultList();
		// if user already exist delete it first
		for (User user : users) {
			if (user.getId().equals("9999")) {
				logger.info("Before adding a user: delete the already existing user");
				deleteUser();
			}
		}
		
		logger.info("Test: Adding user with id = 9999");
		CreateUserService service = new CreateUserService();
		CreateUserService.ServiceArgument arg = service.getArgument();
		arg.email = "testuser@company.org";
		arg.firstName = "firstName";
		arg.name = "name";
		arg.shortName = "dummyYummy";
		arg.id = "9999";
		arg.password = "12345";
		IResult<User> result = doService(service);
		assertTrue(result.getStatus() == Status.SUCCESS);
		result = doService(service);
		logger.info("Test: Adding user with id = 9999 again with failed result");
		assertTrue(result.getStatus() == Status.FAIL);
	}

	@Test
	public void getUsers() {
		logger.info("Test: Getting user");
		FindAllDaoQuery<User> query = new FindAllDaoQuery<User>(XMLUserObjectDAO.class);
		IResult<User> result = doQuery(query);
		Collection<User> users = result.getResultList();
		if (users != null) {
			logger.info("Found users: #"+users.size());
			for (User user : users) {
				if (user.getId().equals("9999")) {
					logger.info("Test: Found user with id = 9999");
					assertTrue(true);
				}
			}
		}
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void authenticateUser() {
		
		addUser();
		
		UserAuthorizationFilter<User> filter = new UserAuthorizationFilter<User>("9999", "12345");
		DefaultFilterQuery<User> query = new DefaultFilterQuery(new FindAllDaoSelection(XMLUserObjectDAO.class), filter);
		IResult<User> result = doQuery(query);
		logger.info("Test: Authenticate user, found #"+result.getResultList().size());
		assertTrue(result.getResultList().size() > 0);
		
		// Try to authenticate with a wrong password
		filter = new UserAuthorizationFilter<User>("9999", "11111");
		query = new DefaultFilterQuery(new FindAllDaoSelection(XMLUserObjectDAO.class), filter);
		result = doQuery(query);
		assertTrue(result.getResultList().size() == 0);
		
		deleteUser();
		
	}
	
	@Test
	public void deleteUser() {
		logger.info("Test: Deleting user with id = 9999");
		DeleteUserService service = new DeleteUserService();
		DeleteUserService.ServiceArgument arg = service.getArgument();
		arg.id = "9999";
		IResult<User> result = doService(service);
		assertTrue(result.getStatus() == Status.SUCCESS);
		
		logger.info("Test: Deleting user with id = 9999 again with failed result");
		result = doService(service);
		assertTrue(result.getStatus() == Status.FAIL);
		logger.info(result.getException());
	}
	
	
}
