/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.model.parameter.IParameter;
import net.form105.rm.base.model.parameter.IntParameter;
import net.form105.rm.base.model.parameter.StringParameter;

/**
 *
 * @author heiko
 */
public class ParameterFactory {
    
    static ParameterFactory instance;
    final String PARAMETER_INT = "intParameter";
    final String PARAMETER_STRING = "stringParameter";
    
    static {
        instance = new ParameterFactory();
    }
    
    public IParameter getParameter(String type) {
        if (type.equals(PARAMETER_STRING)) {
            return new StringParameter();
        } else if (type.equals(PARAMETER_INT)) {
            return new IntParameter();
        }
        throw new RMException("Can't instantiate Parameter by type: "+type+" (not found)");
    }

}
