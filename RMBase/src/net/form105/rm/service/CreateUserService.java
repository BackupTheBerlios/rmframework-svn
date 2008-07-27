package net.form105.rm.service;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

public class CreateUserService extends AbstractService {

	private static final long serialVersionUID = 1L;
	ServiceArgument argument = new ServiceArgument();
	
	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public String id;
		public String email;
		public String name;
		public String firstName;
		public String shortName;
    }

	@Override
	public void execute() throws Exception {
		XMLUserObjectDAO dao = (XMLUserObjectDAO) Agent.getLookup().getContent(XMLUserObjectDAO.class);
		
		User user = new User();
		user.setEMail(argument.email);
		user.setId(argument.id);
		user.setFirstName(argument.firstName);
		user.setSirName(argument.name);
		
		dao.save(user);
	}
	
	public ServiceArgument getArgument() {
        return argument;
    }

}
