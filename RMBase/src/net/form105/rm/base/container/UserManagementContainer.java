package net.form105.rm.base.container;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.user.User;

import org.picocontainer.Startable;

public class UserManagementContainer extends AbstractContainer implements Startable {

	private GlobalLookupContainer lookupContainer;
	private final String USER_CONFIG_FILE = "users.xml";

	public UserManagementContainer(GlobalLookupContainer lookupContainer) {
		super();
		this.lookupContainer = lookupContainer;
	}

	@Override
	public void start() {
		
		String configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
		
		ILookup lookup = lookupContainer.getLookupRegistry();
		XMLUserObjectDAO usersDao = new XMLUserObjectDAO(configDir+USER_CONFIG_FILE);
		lookup.addEntry(XMLUserObjectDAO.class, usersDao);
		
		if (Agent.getRMProperty("server.userManagement.initialize").equals("true")) {
			createDefaultUserEntries();
		}
	}

	@Override
	public void stop() {
		lookupContainer.getLookupRegistry().removeEntry(XMLUserObjectDAO.class);
	}

	/**
	 * Creates default users if there aren't any
	 */
	public void createDefaultUserEntries() {
		XMLUserObjectDAO dao = (XMLUserObjectDAO) lookupContainer.getLookupRegistry().getContent(XMLUserObjectDAO.class);
		logger.info("Creating default users");
		
		ArrayList<String> roleList = new ArrayList<String>();
		roleList.add("user");
		dao.save(createUser("999999", "heiko.kundlacz@kaiser-ag.ch", "Kundlacz", "heiko.kundlacz", "heiko", false, roleList));
		roleList.add("admin");
		dao.save(createUser("1", "admin@kaiser-ag.ch", "Administrator", "admin", "admin", false, roleList));
		
	}
	
	public User createUser(String id, String email, String sirName, String shortName, String password, boolean isAdmin, List<String> roles) {
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
