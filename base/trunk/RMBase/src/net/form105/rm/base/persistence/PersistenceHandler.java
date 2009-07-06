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

import java.util.HashMap;

import net.form105.rm.base.Agent;
import net.form105.rm.base.container.PersistenceModeContainer;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.dao.resource.ResourceMapDao;
import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;

public class PersistenceHandler {

    public static Logger logger = Logger.getLogger(PersistenceHandler.class);
    
    private HashMap<Class<? extends AgentObject>, IBasicDao<? extends AgentObject>> daoMap = new HashMap<Class<? extends AgentObject>, IBasicDao<? extends AgentObject>>();

    

    public PersistenceHandler() {
        ResourceMapDao rMapDao = new ResourceMapDao();
        addDao(Resource.class, rMapDao);
        
        Resource resource = (Resource) getDao(Resource.class).findByElementId("333");
        
    }

    public void saveAgentObject(AgentObject aObject) {
        if (aObject instanceof Resource) {
            PersistenceModeContainer container = Agent.getPersistenceContainer();
            IBasicDao<Resource> dao = container.getResourceDao();
            dao.save((Resource) aObject);
        }
    }

    

    public void addDao(Class<? extends AgentObject> clazz, IBasicDao<? extends AgentObject> dao) {
        daoMap.put(clazz, dao);
    }
    
    public IBasicDao<? extends AgentObject> getDao(Class<? extends AgentObject> clazz) {
        return daoMap.get(clazz);
    }

}
