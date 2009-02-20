/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import javax.persistence.Entity;

import net.form105.rm.base.model.IXmlObjectLoadable;
import net.form105.xml.schema.model.ParameterDocument.Parameter;

import org.apache.xmlbeans.XmlObject;

/**
 * A parameter represents a double value
 * @author hk
 */

@Entity
public class DoubleParameter extends AbstractParameter<Double> implements IXmlObjectLoadable<IParameter> {

    private static final long serialVersionUID = 1L;

    private Double parameterValue;
    
    public DoubleParameter(String id, String name, Double value) {
    	setElementId(id);
    	setName(name);
    	setParameterValue(value);
    }

    public Double getParameterValue() {
        return parameterValue;
    }

    @Override
    public void setParameterValue(Double value) {
        this.parameterValue = value;
    }

    @Override
    public String getValueAsString() {
        return parameterValue.toString();
    }

    @Override
    public IParameter loadFromXml(XmlObject xmlObject) {
        Parameter parameter = (Parameter) xmlObject;
        this.setElementId(parameter.getId());
        this.setName(parameter.getName());
        Double doubleValue = new Double(parameter.getValue());
        this.setParameterValue(doubleValue);
        return this;
    }

}
