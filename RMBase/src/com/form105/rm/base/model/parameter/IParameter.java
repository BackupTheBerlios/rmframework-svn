package com.form105.rm.base.model.parameter;

import java.io.Serializable;



public interface IParameter extends Serializable {

    public String getName();

    public String getParameterId();

    public String getValueAsString();

    public void setName(String name);

    public void setParameterId(String parameterId);

}
