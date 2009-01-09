/*
* Copyright (c) 2008, Heiko Kundlacz
*/

package net.form105.web.base.model.navigation;

/**
 *
 * @author Heiko Kundlacz
 */
public class DefaultNavigationItem implements INavigationItem {
    
    private String id;
    private Class navClass;
    private String resourceKey;
    
    public DefaultNavigationItem(String id, Class navClass, String resourceKey) {
        this.id = id;
        this.navClass = navClass;
        this.resourceKey = resourceKey;
    }

    /* (non-Javadoc)
	 * @see net.form105.web.base.model.navigation.NavigationItem#getId()
	 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see net.form105.web.base.model.navigation.NavigationItem#getNavClass()
	 */
    public Class getNavTargetClass() {
        return navClass;
    }

    public void setNavClass(Class navClass) {
        this.navClass = navClass;
    }

    /* (non-Javadoc)
	 * @see net.form105.web.base.model.navigation.NavigationItem#getResourceKey()
	 */
    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }
    
    

}
