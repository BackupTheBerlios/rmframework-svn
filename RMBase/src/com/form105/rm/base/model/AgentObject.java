package com.form105.rm.base.model;

import java.io.Serializable; 
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AgentObject implements Serializable {

    @Id
    private Long id;

    private String name;

    private String elementId;

    public String getName () {
        return null;
    }

    public void setName (String name) {
    }

    public String getElementId () {
        return null;
    }

    public void setElementId (String elementId) {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

}

