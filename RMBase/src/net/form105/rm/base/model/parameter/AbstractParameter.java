/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import net.form105.rm.base.model.AgentObject;


/**
 *
 * @author heiko
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "parameter_type", discriminatorType=DiscriminatorType.STRING)
public abstract class AbstractParameter<T> extends AgentObject implements IParameter, Serializable {
    
    @Id 
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
