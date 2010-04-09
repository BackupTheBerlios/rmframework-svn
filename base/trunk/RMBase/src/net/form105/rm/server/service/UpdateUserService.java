package net.form105.rm.server.service;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.StaticAgentId;
import net.form105.rm.base.container.UserManagementContainer;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

public class UpdateUserService extends AbstractService {

	private static final long serialVersionUID = 1L;
	ServiceArgument argument = new ServiceArgument();
	
	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public Long id;
		public String email;
		public String name;
		public String firstName;
		public String shortName;
		public String password;
		public boolean isAdmin;
		public List<String> roles;
    }

	@Override
	public void execute() throws Exception {
		
		UserManagementContainer userContainer = (UserManagementContainer) Agent.getContainer(StaticAgentId.USER_MANAGEMENT_ID);
		//XMLUserObjectDAO dao = (XMLUserObjectDAO) Agent.getDaoLookup().getFirstContentObject(User.class);
		
		IBasicDao<User> userDao = userContainer.getUserObjectDao();
		
		// check if user exists already
		User existingUser = userDao.findById(argument.id);
		
		User user = new User();
		user.setEMail(argument.email);
		user.setId(argument.id);
		user.setFirstName(argument.firstName);
		user.setSirName(argument.name);
		user.setPassword(argument.password);
		user.setAdmin(argument.isAdmin);
		user.setRoles(argument.roles);
		userDao.saveOrUpdate(user);
	}
	
	public ServiceArgument getArgument() {
        return argument;
    }

}
