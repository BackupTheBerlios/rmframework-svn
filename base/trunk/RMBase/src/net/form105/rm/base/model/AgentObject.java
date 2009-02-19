package net.form105.rm.base.model;

import java.io.Serializable; 

import net.form105.rm.base.db.MappingTable;


public class AgentObject implements Serializable {
	
	private Double objectId;

    private String name;

    private String elementId;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getElementId () {
        return elementId;
    }

    public void setElementId (String elementId) {
        this.elementId = elementId;
    }
    
    public void setObjectId(Double objectId) {
    	this.objectId = objectId;
    }
    
    public Double getObjectId() {
    	return objectId;
    }

}

