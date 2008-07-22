/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import javax.persistence.Entity;



@Entity
public class ImageParameter extends AbstractParameter<String> {
    
    private String parameterValue;

    @Override
    public String getValueAsString() {
        return parameterValue;
    }

    @Override
    public String getParameterValue() {
       return parameterValue; 
    }

    @Override
    public void setParameterValue(String value) {
        this.parameterValue = value;
    }

}
