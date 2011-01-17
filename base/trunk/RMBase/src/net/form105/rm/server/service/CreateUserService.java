package net.form105.rm.server.service;

import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.container.UserManagementContainer;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.i18n.BaseI18NMessage;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

public class CreateUserService extends AbstractService {

	private static final long serialVersionUID = 1L;
	ServiceArgument argument = new ServiceArgument();

	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public User user;
	}

	@Override
	public void execute() throws Exception {
		
		UserManagementContainer userContainer = (UserManagementContainer) Container.getContainer().getComponent("userMgmt");
		IBasicDao<User> dao = userContainer.getUserObjectDao();

		// check if user exists already
		User existingUser = dao.findById(argument.user.getId());
		if (existingUser != null) {
			BaseI18NMessage message = new BaseI18NMessage();
			throw new RMException(message, "entry.exist", new String[] { existingUser.getId().toString() });
		}

		
		

		dao.save(argument.user);
	}

	public ServiceArgument getArgument() {
		return argument;
	}

}
