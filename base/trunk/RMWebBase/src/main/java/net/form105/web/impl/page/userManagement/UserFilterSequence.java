package net.form105.web.impl.page.userManagement;

import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.user.User;
import net.form105.web.base.model.filter.AbstractFilterSequence;

public class UserFilterSequence extends AbstractFilterSequence<User> {
	
	private static final long serialVersionUID = 1L;

	public UserFilterSequence(ILookup lookup) {
		super(lookup);
	}
}
