package net.form105.rm.base.container;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.user.User;

import org.picocontainer.Startable;

public class UserManagementContainer extends AbstractContainer implements Startable {

    

    private final String USER_CONFIG_FILE = "users.xml";
    private XMLUserObjectDAO usersDao;

    public UserManagementContainer() {
        super();

    }

    public void start() {
    	
    	logger.info("starting UserManagement");

        String configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
        usersDao = new XMLUserObjectDAO(configDir + USER_CONFIG_FILE);


        if (Agent.getRMProperty("server.userManagement.initialize").equals("true")) {
            createDefaultUserEntries();
        }
        
        
    }
    
    

    public void stop() {
    }

    /**
     * Creates default users if there aren't any
     */
    public void createDefaultUserEntries() {
        


        ArrayList<String> roleList = new ArrayList<String>();
        roleList.add("user");
        usersDao.save(createUser(9999L, "heiko.kundlacz@kaiser-ag.ch", "Kundlacz", "heiko.kundlacz", "heiko", false, roleList));
        roleList.add("admin");
        usersDao.save(createUser(1L, "admin@kaiser-ag.ch", "Administrator", "admin", "admin", false, roleList));

    }

    public User createUser(Long id, String email, String sirName, String shortName, String password, boolean isAdmin, List<String> roles) {
        User user = new User();
        user.setId(id);
        user.setEMail(email);
        user.setSirName(sirName);
        user.setShortName(shortName);
        user.setPassword(password);
        user.setAdmin(isAdmin);
        user.setRoles(roles);
        return user;
    }
    
    public IBasicDao<User> getUserObjectDao() {
    	return usersDao;
    }

}
