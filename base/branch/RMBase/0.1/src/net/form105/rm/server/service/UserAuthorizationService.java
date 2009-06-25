package net.form105.rm.server.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

/**
 * This service is responsible to authenticate a user. The argument provides a userId and a password which
 * will should match an existing user. If a user matches against the arguments user and password the
 * authenticated user will be added to the result list. If authentication fails an empty list will be set.
 * @author hk
 *
 */
public class UserAuthorizationService extends AbstractService {

	private static final long serialVersionUID = 1L;
	private ServiceArgument argument = new ServiceArgument();
	
	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public Long userId;
		public String password;
    }

	@Override
	public void execute() throws Exception {
		XMLUserObjectDAO dao = (XMLUserObjectDAO) Agent.getDaoLookup().getFirstContentObject(User.class);
		User user = dao.findById(argument.userId);
		List<User> resultList = new ArrayList<User>();
		
		if (user != null && user.getPassword().equals(argument.password)) {
			resultList.add(user);
		} 
		getResult().setResultList(resultList);
	}
	
	public ServiceArgument getArgument() {
		return argument;
	}
	
	public Collection<User> getEmptyList() {
		return new ArrayList<User>();
	}

}
