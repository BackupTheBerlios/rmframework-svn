/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import java.io.Serializable;

import net.form105.rm.base.model.AgentObject;


/**
 *
 * @author heiko
 */

public abstract class AbstractParameter<T> extends AgentObject implements IParameter, Serializable {
    
    private static final long serialVersionUID = 1L;
    private Long id;
    private String elementId;
    private String name;



    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getValueAsString();
    
    public abstract T getParameterValue();
    
    public abstract void setParameterValue(T value);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
