package net.form105.web.base.model.filter;

import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.user.User;

public class UserFilterSequence extends AbstractFilterSequence<User> {
	
	private static final long serialVersionUID = 1L;

	public UserFilterSequence(ILookup lookup) {
		super(lookup);
	}
}
