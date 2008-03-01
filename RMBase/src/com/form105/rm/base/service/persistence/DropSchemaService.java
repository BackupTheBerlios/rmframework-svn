/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base.service.persistence;

import com.form105.rm.base.persistence.SchemaHelper;
import com.form105.rm.base.service.common.*;
import com.form105.rm.base.service.AbstractService;
import com.form105.rm.base.service.IArgument;
import java.io.Serializable;

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
