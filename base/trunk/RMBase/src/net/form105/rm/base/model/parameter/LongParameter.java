/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;


/**
 * A Long parameter which encapsulates a Long 
 * @author hk
 */

public class LongParameter extends AbstractParameter<Long> {

    private static final long serialVersionUID = 1L;

    private Long parameterValue;
    
    public LongParameter() {
    	
    }
    
    public LongParameter(String id, String name, Long value) {
    	setElementId(id);
    	setName(name);
    	setParameterValue(value);
    }

    public Long getParameterValue() {
        return parameterValue;
    }

    @Override
    public void setParameterValue(Long value) {
        this.parameterValue = value;
    }

    @Override
    public String getValueAsString() {
        return parameterValue.toString();
    }


}
