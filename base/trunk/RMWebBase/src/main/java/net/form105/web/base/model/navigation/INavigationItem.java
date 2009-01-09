package net.form105.web.base.model.navigation;

import java.io.Serializable;

public interface INavigationItem extends Serializable{

	/**
	 * The id of the item
	 * @return
	 */
	public abstract String getId();

	public abstract Class getNavTargetClass();

	public abstract String getResourceKey();

}