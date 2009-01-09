package net.form105.web.base.component.login.authorize;

import net.form105.web.base.IType;

public class UserAuthorizedState implements IType {
	
	private final int typeCode = 1;

	@Override
	public int getTypeCode() {
		return typeCode;
	}

}
