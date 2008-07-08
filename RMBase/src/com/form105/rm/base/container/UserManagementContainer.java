package com.form105.rm.base.container;

import org.picocontainer.Startable;

import com.form105.rm.base.dao.XMLUserObjectDAO;
import com.form105.rm.base.lookup.EntryLookupRegistry;
import com.form105.rm.base.model.user.User;

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
		// TODO Auto-generated method stub
		
	}
	
	public void createDefaultUserEntries() {
		User user = new User();
		user.setId(1L);
		
	}

}
