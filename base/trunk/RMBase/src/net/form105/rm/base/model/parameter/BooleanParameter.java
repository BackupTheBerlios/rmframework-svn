/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;


/**
 *
 * @author hk
 */

public class BooleanParameter extends AbstractParameter<Boolean> {

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

}
