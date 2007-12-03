/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base.service.common;

import com.form105.rm.base.exception.RMException;
import com.form105.rm.base.service.AbstractService;
import java.io.Serializable;

/**
 *
 * @author heiko
 */
public class PrintService extends AbstractService implements Serializable {
    
    private final String serviceName = "PrintService";
    private ServiceArgument argument = new ServiceArgument();

    public class ServiceArgument implements Serializable {
        public String name;
    }

    public void execute() throws RMException {
        logger.info("Executed PrintService");
    }

    public ServiceArgument getArgument() {
        return argument;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
