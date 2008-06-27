package net.form105.web.base.model.navigation;

public class LoginNavigationItem implements INavigationItem {

	private enum LoginState {
		LOGGEDOUT(), LOGGEDIN();
	}

	private LoginState state;
	private final String loggedinId = "loggedIn";
	private final String loggedoutId = "loggedOut";
	
	public LoginNavigationItem(LoginState loginState) {
		this.state = loginState;
	}

	@Override
	public String getId() {

		switch (state.ordinal()) {
		case 0:
			return loggedoutId;
		case 1:
			return loggedinId;
		}
		return "";
	}

	@Override
	public Class getNavTargetClass() {
		
		return null;
	}

	@Override
	public String getResourceKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
