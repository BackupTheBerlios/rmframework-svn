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
package net.form105.rm.base.dao.resource;

import java.util.List;

import net.form105.rm.base.model.AgentObject;

import com.db4o.ObjectContainer;
import com.db4o.foundation.NotSupportedException;
import com.db4o.query.Predicate;

public class AgentObjectDb4oDao extends AbstractAgentObjectDao<AgentObject> {
    
    private ObjectContainer db;

    /**
     * The constructor used for dual mode operation. In dual mode a transient map is available
     * for fast read access. 
     * @param transientDao
     */
    public AgentObjectDb4oDao(AbstractAgentObjectDao<AgentObject> transientDao, ObjectContainer objectContainer) {
        super(transientDao);
        db = objectContainer;
    }

    public AgentObjectDb4oDao() {
        super();
    }

    @Override
    public void delete(AgentObject object) {
        db.delete(object);
        db.commit();
        
    }

    @Override
    public List<AgentObject> findAll() {
        List<AgentObject> aoList = db.query(AgentObject.class);
        return aoList;
    }

    @Override
    public AgentObject findByElementId(final String elementId) {
        List<AgentObject> agentObjectList = db.query(new Predicate<AgentObject>() {

            @Override
            public boolean match(AgentObject agentObject) {
                return elementId.equals(agentObject.getElementId());
            }
        });
        if (agentObjectList.size() > 0 ) return agentObjectList.get(0);
        return null;
    }

    @Override
    public AgentObject findById(Long id) {
        throw new NotSupportedException();
    }

    @Override
    public AgentObject merge(AgentObject object) {
        throw new NotSupportedException();
    }

    @Override
    public void save(AgentObject object) {
        db.store(object);
        db.commit();
        
    }

    @Override
    public void saveOrUpdate(AgentObject object) {
        db.store(object);
        db.commit(); 
    }

    @Override
    public void update(AgentObject object) {
        db.store(object);
        db.commit();
    }

}
