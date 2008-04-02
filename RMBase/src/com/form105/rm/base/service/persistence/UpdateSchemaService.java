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
public class UpdateSchemaService extends AbstractService implements Serializable {
    
    private final String serviceName = "UpdateSchema";
    private ServiceArgument argument = new ServiceArgument();

    public class ServiceArgument implements IArgument {
        public String schemaName;
    }

    public void execute()  {
        SchemaHelper sHelper = new SchemaHelper(getArgument().schemaName);
        logger.info("Argument of Service: "+getArgument().schemaName);
        sHelper.updateSchema();
        
    }

    public ServiceArgument getArgument() {
        return argument;
    }
}
