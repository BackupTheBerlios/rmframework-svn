package com.form105.rm.base.model.parameter;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public interface IParameter extends Serializable {
    @Id
    public Long id;
    
    public Long getId();
    
    public String getName();

    public String getParameterId();

    public String getValueAsString();

    public void setName(String name);

    public void setParameterId(String parameterId);

}
