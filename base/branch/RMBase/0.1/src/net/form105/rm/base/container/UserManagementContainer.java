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

    private LookupContainer lookupContainer;

    private final String USER_CONFIG_FILE = "users.xml";

    public UserManagementContainer(LookupContainer lookupContainer) {
        super();
        this.lookupContainer = lookupContainer;
    }

    public void start() {

        String configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();

        ILookup lookup = lookupContainer.getDaoLookup();
        XMLUserObjectDAO usersDao = new XMLUserObjectDAO(configDir + USER_CONFIG_FILE);
        lookup.addContentObject(User.class, usersDao);

        if (Agent.getRMProperty("server.userManagement.initialize").equals("true")) {
            createDefaultUserEntries();
        }
        
        MyClass<AgentObject> myClass = new MyClass<AgentObject>();
        myClass.remove(new User());
        myClass.add(User.class);
    }
    
    private class MyClass<T> {
        
        public void remove(T object) {
            
        }
        
        public <M extends T> void add(Class<M> object) {
            
        }
    }

    public void stop() {
        lookupContainer.getDaoLookup().removeEntry(User.class);
    }

    /**
     * Creates default users if there aren't any
     */
    public void createDefaultUserEntries() {
        
        XMLUserObjectDAO dao = (XMLUserObjectDAO) lookupContainer.getDaoLookup().getFirstContentObject(User.class);
        logger.info("Creating default users");

        ArrayList<String> roleList = new ArrayList<String>();
        roleList.add("user");
        dao.save(createUser(9999L, "heiko.kundlacz@kaiser-ag.ch", "Kundlacz", "heiko.kundlacz", "heiko", false, roleList));
        roleList.add("admin");
        dao.save(createUser(1L, "admin@kaiser-ag.ch", "Administrator", "admin", "admin", false, roleList));

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

}
