package net.form105.rm.base.user;

import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;

import net.form105.rm.base.container.UserManagementContainer;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.AbstractRemoteTest;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.server.service.CreateUserService;

import org.apache.log4j.Logger;
import org.junit.Test;


public class CreateBulkUsersTest extends AbstractRemoteTest<User> {

	public static Logger logger = Logger.getLogger(CreateBulkUsersTest.class);
	

	public void addUser(User user) {
		// check if user exist

		CreateUserService service = new CreateUserService();
		CreateUserService.ServiceArgument arg = service.getArgument();
		arg.user = user;
		IResult<User> result = doService(service);
		assertTrue(result.getStatus() == ResultStatus.SUCCESS);
	}

	@Test
	public void createUsers() {
		UserManagementContainer userContainer = new UserManagementContainer();
		ArrayList<String> roleList = new ArrayList<String>();
		roleList.add("user");
		for (int i = 1; i < 201; i++) {
			User user = userContainer.createUser(100000L+i, "user"+i+"@kaiser-ag.ch", "sirname"+i, "shortname"+i, "1234", false, roleList);
			addUser(user);
		}
	}
}
