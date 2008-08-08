package com.form105.rm.base.user;

import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;

import net.form105.rm.base.container.UserManagementContainer;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.Status;
import net.form105.rm.server.service.CreateUserService;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class CreateBulkUsersTest extends AbstractRemoteTest<User> {

	public static Logger logger = Logger.getLogger(CreateBulkUsersTest.class);
	

	public void addUser(User user) {
		// check if user exist

		CreateUserService service = new CreateUserService();
		CreateUserService.ServiceArgument arg = service.getArgument();
		arg.email = user.getEMail();
		arg.firstName = user.getFirstName();
		arg.name = user.getSirName();
		arg.shortName = user.getShortName();
		arg.id = user.getId();
		arg.password = user.getPassword();
		arg.isAdmin = user.isAdmin();
		arg.roles = user.getRoles();
		IResult<User> result = doService(service);
		assertTrue(result.getStatus() == Status.SUCCESS);
	}

	@Test
	public void createUsers() {
		UserManagementContainer userContainer = new UserManagementContainer(null);
		ArrayList<String> roleList = new ArrayList<String>();
		roleList.add("user");
		for (int i = 1; i < 201; i++) {
			User user = userContainer.createUser(String.valueOf(100000+i), "user"+i+"@kaiser-ag.ch", "sirname"+i, "shortname"+i, "1234", false, roleList);
			addUser(user);
		}
	}
}
