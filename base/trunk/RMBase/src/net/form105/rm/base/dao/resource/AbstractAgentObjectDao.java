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

import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.model.AgentObject;


public abstract class AbstractAgentObjectDao<T extends AgentObject> implements IBasicDao<T> {

    private AbstractAgentObjectDao<T> transientDao;

    public AbstractAgentObjectDao(AbstractAgentObjectDao<T> transientDao) {
        this.transientDao = transientDao;
    }
    
    public AbstractAgentObjectDao() {};

    @Override
    public abstract void delete(T object);

    @Override
    public abstract List<T> findAll();

    @Override
    public abstract T findByElementId(String elementId);

    @Override
    public abstract T findById(Long id);

    @Override
    public abstract T merge(T object);

    @Override
    public abstract void save(T object);

    @Override
    public abstract void saveOrUpdate(T object);

    @Override
    public abstract void update(T object);

    public AbstractAgentObjectDao<T> getTransientDao() {
        return transientDao;
    }

    public void setTransientDao(AbstractAgentObjectDao<T> transientDao) {
        this.transientDao = transientDao;
    }

    public AbstractAgentObjectDao<T> getReadDao() {
        if (transientDao == null) {
            return this;
        } else {
            return transientDao;
        }
    }
}
