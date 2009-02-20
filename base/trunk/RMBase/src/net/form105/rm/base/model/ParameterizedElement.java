/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.form105.rm.base.model.parameter.AbstractParameter;

public abstract class ParameterizedElement extends AgentObject implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;

    private String type;

    private Map<String, AbstractParameter> parameterMap = new HashMap<String, AbstractParameter>();

    public Map<String, AbstractParameter> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(HashMap<String, AbstractParameter> parameterSet) {
        this.parameterMap = parameterSet;
    }
    
    public void addParameter(AbstractParameter parameter) {
        parameterMap.put(parameter.getElementId(), parameter);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Collection<AbstractParameter> getParameters() {
        return parameterMap.values();
    }
    
    public AbstractParameter getParameterById(String id) {
    	return parameterMap.get(id);
    }
    
}
