/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.form105.rm.base.service.persistence;

import java.io.Serializable;

import net.form105.rm.base.persistence.SchemaHelper;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;
import net.form105.rm.base.service.common.*;

/**
 *
 * @author heiko
 */
public class DropSchemaService extends AbstractService implements Serializable {
    
    private final String serviceName = "UpdateSchema";
    private ServiceArgument argument = new ServiceArgument();

    public class ServiceArgument implements IArgument {
        public String schemaName;
    }

    public void execute()  {
        SchemaHelper sHelper = new SchemaHelper(getArgument().schemaName);
        sHelper.dropSchema();
        
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
