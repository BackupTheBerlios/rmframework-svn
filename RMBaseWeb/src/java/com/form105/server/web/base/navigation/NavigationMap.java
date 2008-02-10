/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.server.web.base.navigation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author heiko
 */
public class NavigationMap {
    
    private HashMap<String, List<NavigationItem>> navigationMap = new HashMap<String, List<NavigationItem>>();

    public void register(String id, Class navTarget, String section, String resourceKey) {
        
        List<NavigationItem> sectionList = getNavigationMap().get(section);
        
        if (sectionList == null) {
            sectionList = new ArrayList<NavigationItem>();
        }
        
        sectionList.add(new NavigationItem(id, navTarget,resourceKey));
    }

    public HashMap<String, List<NavigationItem>> getNavigationMap() {
        return navigationMap;
    }

    public void setNavigationMap(HashMap<String, List<NavigationItem>> navigationMap) {
        this.navigationMap = navigationMap;
    }
    
    
}
