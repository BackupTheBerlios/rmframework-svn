package net.form105.rm.selection;

import java.util.Collection;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.selection.AbstractSelection;

/**
 * A selection which returns all users
 * @author hk
 *
 */
public class UserSelection extends AbstractSelection<User> {

	@Override
	public Collection<User> select() {		
		XMLUserObjectDAO dao = (XMLUserObjectDAO) Agent.getLookup().getContent(XMLUserObjectDAO.class);
		return dao.findAll();
	}

}
