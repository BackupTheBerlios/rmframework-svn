package net.form105.rm;

import java.util.Collection;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.selection.AbstractSelection;


public class AllUsersSelection extends AbstractSelection<User> {

	@Override
	public Collection<User> select() {
		XMLUserObjectDAO userDao = (XMLUserObjectDAO) Agent.getLookup().getContent(XMLUserObjectDAO.class);
		return userDao.findAll();
	}

}
