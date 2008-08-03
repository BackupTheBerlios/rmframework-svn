package net.form105.rm.base.container;

import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.lookup.EntryLookupRegistry;
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
		
		EntryLookupRegistry lookup = lookupContainer.getLookupRegistry();
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
		logger.info("Creating default user: admin");
		//if (dao.findAll().size() == 0)
		//	return;
		User user = new User();
		user.setId("1");
		user.setEMail("heiko.kundlacz@gmx.net");
		user.setSirName("Administrator");
		user.setShortName("admin");
		user.setPassword("admin");
		dao.save(user);
	}

}
