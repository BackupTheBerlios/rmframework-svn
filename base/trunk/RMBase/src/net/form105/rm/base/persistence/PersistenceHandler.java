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
package net.form105.rm.base.persistence;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;

public class PersistenceHandler {
    
    public static Logger logger = Logger.getLogger(PersistenceHandler.class);
    
    public void saveAgentObject(AgentObject aObject) {
        
        Class<? extends AgentObject> clazz = aObject.getClass();
        ILookup daoLookup = Agent.getDaoLookup();
        
        List<AbstractAgentObjectDao<Resource>> daoList = (List<AbstractAgentObjectDao<Resource>>) daoLookup.getEntryAsList(clazz);
        
        
        for (AbstractAgentObjectDao<Resource> dao : daoList) {
            logger.info(dao);
            dao.save((Resource) aObject);
            
        }
    }

}
