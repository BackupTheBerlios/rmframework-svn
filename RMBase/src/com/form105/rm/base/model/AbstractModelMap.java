/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.CollectionOfElements;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractModelMap<T extends AgentObject> implements ModelMap {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long oid;
    
    @CollectionOfElements
    @JoinColumn(name = "modelMapId")
    @Column(name = "parameterizedElement", nullable=false) private Map<String, ParameterizedElement> modelMap = Collections.synchronizedMap(new HashMap<String, ParameterizedElement>());
    
    
    public void addAll(Collection<ParameterizedElement> list) {
        
        //TODO id must be unique
        for (ParameterizedElement element : list) {
            getModelMap().put(element.getElementId(), element);
        }
    }
    
    public void clear() {
        getModelMap().clear();
    }
    
    public void add(ParameterizedElement element) {
        getModelMap().put(element.getElementId(), element);
    }
    
    public void remove(ParameterizedElement element) {
        getModelMap().remove(element.getElementId());
    }

    public Map<String, ParameterizedElement> getModelMap() {
        return modelMap;
    }

    public void setModelMap(Map<String, ParameterizedElement> modelMap) {
        this.modelMap = modelMap;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }
    
    

}
