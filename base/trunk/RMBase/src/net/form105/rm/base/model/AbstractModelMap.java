/*
* Copyright (c) 2011, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AbstractModelMap<T extends IAgentObject> implements ModelMap, Serializable {
    
	private static final long serialVersionUID = 6106918335854930312L;

	  
    private Map<String, T> modelMap = Collections.synchronizedMap(new HashMap<String, T>()); 
    
    public void addAll(Collection<T> list) {
        for (T element : list) {
            modelMap.put(element.getElementId(), element);
        }
    }
    
    public void clear() {
        getModelMap().clear();
    }
    
    /**
     * Adding a model object to the map
     * @param element
     */
    public synchronized void add(T element) {
        getModelMap().put(element.getElementId(), element);
    }
    
    /**
     * Removes a model object from the map
     * @param element
     */
    public void remove(T element) {
        modelMap.remove(element.getElementId());
    }
    
    /**
     * Removes a model object by its id from the map
     * @param elementId
     */
    public void removeById(String elementId) {
    	modelMap.remove(elementId);
    }

    /**
     * Getting the model map
     * @return
     */
    public Map<String, T> getModelMap() {
        return modelMap;
    }

    /**
     * Sets the map of model objects
     * @param modelMap
     */
    public void setModelMap(Map<String, T> modelMap) {
        this.modelMap = modelMap;
    }
    
    /**
	 * Get a agent object by its id.
	 * @param id
	 * @return
	 */
	public T getElementById(String id) {
		return modelMap.get(id);
	}
	
	/**
	 * Getting all existing workflows
	 * 
	 * @return Collection of workflows
	 */
	public Collection<T> getAll() {
		return modelMap.values();
	}
	
	/**
	 * Reset the model map. Cleans out the map and sets all agents objects provided by the list.
	 * @param agentObjects
	 */
	public void setAll(Collection<T> agentObjects) {
		modelMap.clear();
		for (T agentObject : agentObjects) {
			modelMap.put(agentObject.getElementId(), agentObject);
		}
	}
    
    
}
