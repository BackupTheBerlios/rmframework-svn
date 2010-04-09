package net.form105.rm.server.selection;

import java.util.List;

import net.form105.rm.base.Container;
import net.form105.rm.base.container.UserManagementContainer;
import net.form105.rm.base.dao.IBasicDao;
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
        
        
        UserManagementContainer userContainer = (UserManagementContainer) Container.getContainer().getComponent("userMgmt");
        IBasicDao<User> dao = userContainer.getUserObjectDao();
        List<User> userList = dao.findAll();
        return userList;
    }

}
