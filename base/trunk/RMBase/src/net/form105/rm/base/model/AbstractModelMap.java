/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class AbstractModelMap<T extends IAgentObject> implements ModelMap, Serializable {
    
    private HashMap<String, ParameterizedElement> modelMap = (HashMap) Collections.synchronizedMap(new HashMap<String, ParameterizedElement>());
    
    public void addAll(Collection<ParameterizedElement> list) {
        
        //TODO id must be unique
        for (ParameterizedElement element : list) {
            getModelMap().put(element.getElementId(), element);
        }
    }
    
    public void clear() {
        getModelMap().clear();
    }
    
    public synchronized void add(ParameterizedElement element) {
        getModelMap().put(element.getElementId(), element);
    }
    
    public void remove(ParameterizedElement element) {
        getModelMap().remove(element.getElementId());
    }

    public HashMap<String, ParameterizedElement> getModelMap() {
        return modelMap;
    }

    public void setModelMap(HashMap<String, ParameterizedElement> modelMap) {
        this.modelMap = modelMap;
    }
}
