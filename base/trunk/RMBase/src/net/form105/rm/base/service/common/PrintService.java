/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.form105.rm.base.service.common;

import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

/**
 *
 * @author heiko
 */
public class PrintService extends AbstractService {
    
    private final String serviceName = "PrintService";
    private ServiceArgument argument = new ServiceArgument();

    public class ServiceArgument implements IArgument {
        public String name = "Default";
    }

    public void execute() throws RMException {
        logger.info("Executed PrintService");
        logger.info(getArgument().name);
        
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
