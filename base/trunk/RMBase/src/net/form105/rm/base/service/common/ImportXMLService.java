/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.form105.rm.base.service.common;

import java.io.Serializable;

import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;
import net.form105.rm.server.command.LoadXmlModelCommand;

/**
 *
 * @author heiko
 */
public class ImportXMLService extends AbstractService implements Serializable {

    private static final long serialVersionUID = 1L;

    ServiceArgument argument = new ServiceArgument();

    public class ServiceArgument implements IArgument {
        private static final long serialVersionUID = 1L;
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
