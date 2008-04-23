/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base.service.common;

import com.form105.rm.base.exception.RMException;
import com.form105.rm.base.service.AbstractService;
import com.form105.rm.base.service.IArgument;
import com.form105.rm.command.LoadXmlModelCommand;
import java.io.Serializable;

/**
 *
 * @author heiko
 */
public class ImportXMLService extends AbstractService implements Serializable {

    
    ServiceArgument argument = new ServiceArgument();

    public class ServiceArgument implements IArgument {
        public String modelName;
    }

    public void execute() throws RMException {
        ServiceArgument arg = (ServiceArgument) argument;
        LoadXmlModelCommand command = new LoadXmlModelCommand(arg.modelName);
        command.execute();
        
    }

    public ServiceArgument getArgument() {
        return argument;
    }

}
