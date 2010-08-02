/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import net.form105.rm.base.model.IXmlObjectLoadable;
import net.form105.xml.schema.model.ParameterDocument.Parameter;

import org.apache.xmlbeans.XmlObject;

/**
 * Don't use this. 
 * @deprecated Use LongParameter instead
 * @author hk
 */

public class IntParameter extends AbstractParameter<Integer> implements IXmlObjectLoadable<IParameter> {

    private static final long serialVersionUID = 1L;

    private Integer parameterValue;
    
    public IntParameter() {
    	
    }
    
    public IntParameter(String id, String name, Integer value) {
    	setElementId(id);
    	setName(name);
    	setParameterValue(value);
    }

    public Integer getParameterValue() {
        return parameterValue;
    }

    @Override
    public void setParameterValue(Integer value) {
        this.parameterValue = value;
    }

    @Override
    public String getValueAsString() {
        return parameterValue.toString();
    }

    public IParameter loadFromXml(XmlObject xmlObject) {
        Parameter parameter = (Parameter) xmlObject;
        this.setElementId(parameter.getId());
        this.setName(parameter.getName());
        Integer intValue = new Integer(parameter.getValue());
        this.setParameterValue(intValue);
        return this;
    }

}
