package com.form105.rm.base.user;

import static junit.framework.Assert.assertTrue;

import java.util.Collection;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.FindAllDaoQuery;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ServiceResult;
import net.form105.rm.base.service.Status;
import net.form105.rm.server.service.CreateUserService;
import net.form105.rm.server.service.DeleteUserService;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class UserManagementTest extends AbstractRemoteTest<User> {

	public static Logger logger = Logger.getLogger(UserManagementTest.class);
	
	@Test
	public void addUser() {
		logger.info("Test: Adding user with id = 9999");
		CreateUserService service = new CreateUserService();
		CreateUserService.ServiceArgument arg = service.getArgument();
		arg.email = "testuser@company.org";
		arg.firstName = "firstName";
		arg.name = "name";
		arg.shortName = "dummyYummy";
		arg.id = "9999";
		ServiceResult<User> result = doService(service);
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
	public void deleteUser() {
		logger.info("Test: Deleting user with id = 9999");
		DeleteUserService service = new DeleteUserService();
		DeleteUserService.ServiceArgument arg = service.getArgument();
		arg.id = "9999";
		ServiceResult<User> result = doService(service);
		assertTrue(result.getStatus() == Status.SUCCESS);
		
		logger.info("Test: Deleting user with id = 9999 again with failed result");
		result = doService(service);
		assertTrue(result.getStatus() == Status.FAIL);
		logger.info(result.getException());
	}
	
	
}
