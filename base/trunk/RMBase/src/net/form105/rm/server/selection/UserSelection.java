package net.form105.rm.server.selection;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.selection.AbstractSelection;

/**
 * A selection which returns all users
 * @author hk
 *
 */
public class UserSelection extends AbstractSelection<User> {

    private static final long serialVersionUID = 1L;

    @Override
    public List<User> select() {
        ILookup lookup = Agent.getDaoLookup();
        XMLUserObjectDAO dao = (XMLUserObjectDAO) lookup.getFirstContentObject(User.class);
        return dao.findAll();
    }

}
