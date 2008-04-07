/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.model;

import com.form105.rm.base.model.parameter.AbstractParameter;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ParameterizedElement extends AgentObject implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long oid;
    
    private String elementId;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="parameter_id")
    @MapKey(name="elementId")
    private Map<String, AbstractParameter> parameterMap = new HashMap<String, AbstractParameter>();

    public Map<String, AbstractParameter> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(HashMap<String, AbstractParameter> parameterSet) {
        this.parameterMap = parameterSet;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }
    
    public void addParameter(AbstractParameter parameter) {
        parameterMap.put(parameter.getElementId(), parameter);
    }
    
    @Override
    public String getElementId() {
        return elementId;
    }
    
    @Override
    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
    
}
