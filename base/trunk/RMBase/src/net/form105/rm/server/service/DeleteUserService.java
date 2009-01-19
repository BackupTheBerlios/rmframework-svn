package net.form105.rm.server.service;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;
import net.form105.rm.server.i18n.BaseI18NMessage;

public class DeleteUserService extends AbstractService {
	
	private static final long serialVersionUID = 1L;
	ServiceArgument argument = new ServiceArgument();
	
	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public Long id;
    }

	@Override
	public void execute() throws Exception {
		XMLUserObjectDAO dao = (XMLUserObjectDAO) Agent.getDaoLookup().getFirstContentObject(User.class);
		// check if user exists already
		User existingUser = dao.findById(argument.id);
		if (existingUser == null) {
			BaseI18NMessage message = new BaseI18NMessage();
			throw new RMException(message, "entry.notExist", new String[] {argument.id.toString()});
		}
		
		// It would be better to have a dao method which takes an id as a parameter
		User user = new User();
		user.setId(argument.id);
		dao.delete(user);

	}
	
	public ServiceArgument getArgument() {
		return argument;
	}
}
