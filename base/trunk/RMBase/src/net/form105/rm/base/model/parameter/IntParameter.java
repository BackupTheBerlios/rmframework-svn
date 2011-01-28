/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;


/**
 * Don't use this. 
 * @deprecated Use LongParameter instead
 * @author hk
 */

public class IntParameter extends AbstractParameter<Integer>  {

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

}
