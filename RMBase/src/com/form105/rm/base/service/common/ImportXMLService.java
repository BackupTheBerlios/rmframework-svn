/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base.service.common;

import com.form105.rm.base.command.ImportXMLModelCommand;
import com.form105.rm.base.exception.RMException;
import com.form105.rm.base.service.AbstractService;
import com.form105.rm.base.service.IArgument;
import com.form105.rm.base.service.ServiceResult;
import java.io.Serializable;

/**
 *
 * @author heiko
 */
public class ImportXMLService extends AbstractService implements Serializable {
    
    private final String serviceName = "PrintService";
    
    ServiceArgument argument = new ServiceArgument();

    public class ServiceArgument implements IArgument {
        public String filePath;
    }

    public void execute() throws RMException {
        //ServiceArgument arg = (ServiceArgument) argument;
        //ImportXMLModelCommand command = new ImportXMLModelCommand(arg.filePath);
        //command.execute();
        
    }

    public ServiceArgument getArgument() {
        return argument;
    }

    @Override
    public String getServiceName() {
        return this.getClass().getName();
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
