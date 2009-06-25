/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.form105.rm.base.importToModel;

import net.form105.rm.base.model.Resource;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.server.service.LoadXmlModelService;

import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;


public class ImportXmlModelTest extends AbstractRemoteTest<Resource>{
    
    @Test
    public void importModel() {
        LoadXmlModelService service = new LoadXmlModelService();
        LoadXmlModelService.ServiceArgument argument = service.getArgument();
        argument.filename = "testModel.xml";
        
        IResult<Resource> result = doService(service);
        if (ResultStatus.FAIL == result.getStatus()) {
            logger.error("Service terminated unsuccessful");
        }
    }

}
