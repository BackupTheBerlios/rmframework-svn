/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.server.web.base.navigation;

/**
 *
 * @author heiko
 */
public class NavigationItem {
    
    private String id;
    private Class navClass;
    private String resourceKey;
    
    public NavigationItem(String id, Class navClass, String resourceKey) {
        this.id = id;
        this.navClass = navClass;
        this.resourceKey = resourceKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class getNavClass() {
        return navClass;
    }

    public void setNavClass(Class navClass) {
        this.navClass = navClass;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }
    
    

}
