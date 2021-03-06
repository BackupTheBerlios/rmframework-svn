package net.form105.rm.server.service;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;
import net.form105.rm.server.i18n.BaseI18NMessage;

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
		XMLUserObjectDAO dao = (XMLUserObjectDAO) Agent.getDaoLookup().getFirstContentObject(User.class);
		
		// check if user exists already
		User existingUser = dao.findById(argument.id);
		
		User user = new User();
		user.setEMail(argument.email);
		user.setId(argument.id);
		user.setFirstName(argument.firstName);
		user.setSirName(argument.name);
		user.setPassword(argument.password);
		user.setAdmin(argument.isAdmin);
		user.setRoles(argument.roles);
		dao.saveOrUpdate(user);
	}
	
	public ServiceArgument getArgument() {
        return argument;
    }

}
