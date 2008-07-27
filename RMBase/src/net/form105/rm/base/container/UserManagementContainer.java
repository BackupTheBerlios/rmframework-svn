package net.form105.rm.base.container;

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
		EntryLookupRegistry lookup = lookupContainer.getLookupRegistry();
		XMLUserObjectDAO usersDao = new XMLUserObjectDAO(USER_CONFIG_FILE);
		lookup.addEntry(XMLUserObjectDAO.class, usersDao);
	}

	@Override
	public void stop() {
		lookupContainer.getLookupRegistry().removeEntry(XMLUserObjectDAO.class);
	}
	
	/**
	 * Creates default users if there aren't any
	 */
	public void createDefaultUserEntries() {
		XMLUserObjectDAO dao = (XMLUserObjectDAO) lookupContainer.getLookupRegistry().getEntry(XMLUserObjectDAO.class);
		if (dao.findAll().size() == 0) return;
		User user = new User();
		user.setId("1");
		user.setShortName("admin");
		user.setPassword("admin");
		dao.save(user);
	}
	
	
}
