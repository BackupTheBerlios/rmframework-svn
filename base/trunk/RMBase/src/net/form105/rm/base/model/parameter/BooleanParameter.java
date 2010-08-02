/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import net.form105.rm.base.model.IXmlObjectLoadable;
import net.form105.xml.schema.model.ParameterDocument;

import org.apache.xmlbeans.XmlObject;

/**
 *
 * @author hk
 */

public class BooleanParameter extends AbstractParameter<Boolean> implements IXmlObjectLoadable<IParameter> {

    private static final long serialVersionUID = 1L;

    private Boolean parameterValue;
    
    public BooleanParameter() {}
    
    public BooleanParameter(Boolean value) {
    	this.parameterValue = value;
    }

    public Boolean getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(Boolean value) {
        this.parameterValue = value;
    }

    public String getValueAsString() {
        return parameterValue.toString();
    }

    public IParameter loadFromXml(XmlObject xmlObject) {
        ParameterDocument.Parameter parameter = (ParameterDocument.Parameter) xmlObject;
        this.setElementId(parameter.getId());
        this.setName(parameter.getName());
        Boolean boolValue = new Boolean(parameter.getValue());
        this.setParameterValue(boolValue);
        return this;
    }

}
