/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.model.parameter;

import javax.persistence.Entity;

/**
 *
 * @author heiko
 */

@Entity
public class StringParameter extends AbstractParameter<String> {

    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        super.value = value;
    }

    @Override
    public String getValueAsString() {
        return value;
    }
    
}
