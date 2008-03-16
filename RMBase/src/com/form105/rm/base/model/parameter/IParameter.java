package com.form105.rm.base.model.parameter;

import java.io.Serializable;



public interface IParameter extends Serializable {

    public String getName();

    public String getElementId();

    public String getValueAsString();

    public void setName(String name);

    public void setElementId(String parameterId);

}
