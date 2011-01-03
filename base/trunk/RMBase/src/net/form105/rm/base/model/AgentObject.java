package net.form105.rm.base.model;

import java.io.Serializable;


public class AgentObject implements IAgentObject {
	
	private static final long serialVersionUID = 1L;

	private Double objectId;

    private String name;

    private String elementId;

    /* (non-Javadoc)
	 * @see net.form105.rm.base.model.IAgentObject#getName()
	 */
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    /* (non-Javadoc)
	 * @see net.form105.rm.base.model.IAgentObject#getElementId()
	 */
    public String getElementId () {
        return elementId;
    }

    public void setElementId (String elementId) {
        this.elementId = elementId;
    }
    
    public void setObjectId(Double objectId) {
    	this.objectId = objectId;
    }
    
    /* (non-Javadoc)
	 * @see net.form105.rm.base.model.IAgentObject#getObjectId()
	 */
    public Double getObjectId() {
    	return objectId;
    }

}

