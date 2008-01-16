/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.model;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author heiko
 */
class AbstractModelMap<T extends AgentObject> implements ModelMap {
    
    protected Map<String, T> map = Collections.synchronizedMap(new LinkedHashMap<String, T>());
    
    
    public void addAll(Collection<T> list) {
        
        //TODO id must be unique
        for (T element : list) {
            map.put(element.getElementId(), element);
        }
    }
    
    public void clear() {
        map.clear();
    }
    
    public void add(T element) {
        map.put(element.getElementId(), element);
    }
    
    public void remove(T element) {
        map.remove(element.getElementId());
    }
    
    

}
