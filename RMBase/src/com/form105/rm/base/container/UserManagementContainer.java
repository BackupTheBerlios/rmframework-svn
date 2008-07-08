package com.form105.rm.base.container;

import org.picocontainer.Startable;

public class UserManagementContainer extends AbstractContainer implements Startable {
	
	private GlobalLookupContainer lookupContainer;
	
	public UserManagementContainer(GlobalLookupContainer lookupContainer) {
		super();
	}

	@Override
	public void start() {
		
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
