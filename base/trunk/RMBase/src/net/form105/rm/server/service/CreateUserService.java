package net.form105.rm.server.service;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.helper.UniqueIdHelper;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;
import net.form105.rm.server.i18n.BaseMessage;

public class CreateUserService extends AbstractService {

	private static final long serialVersionUID = 1L;
	ServiceArgument argument = new ServiceArgument();

	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public User user;
	}

	@Override
	public void execute() throws Exception {
		XMLUserObjectDAO dao = (XMLUserObjectDAO) Agent.getLookup().getContent(XMLUserObjectDAO.class);

		// check if user exists already
		User existingUser = dao.findById(argument.user.getId());
		if (existingUser != null) {
			BaseMessage message = new BaseMessage();
			throw new RMException(message, "entry.exist", new String[] { existingUser.getId().toString() });
		}

		
		

		dao.save(argument.user);
	}

	public ServiceArgument getArgument() {
		return argument;
	}

}
