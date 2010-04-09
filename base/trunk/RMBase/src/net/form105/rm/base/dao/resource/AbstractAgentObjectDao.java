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
import net.form105.rm.base.dao.NullDao;
import net.form105.rm.base.model.AgentObject;


public abstract class AbstractAgentObjectDao<T extends AgentObject> implements IBasicDao<T> {

    private IBasicDao<T> transientDao = new NullDao<T>();

    public AbstractAgentObjectDao(IBasicDao<T> transientDao) {
        this.transientDao = transientDao;
    }
    
    public AbstractAgentObjectDao() {};

    public abstract void delete(T object);

    public abstract List<T> findAll();

    public abstract T findByElementId(String elementId);

    public abstract T findById(Long id);

    public abstract T merge(T object);

    public abstract void save(T object);

    public abstract void saveOrUpdate(T object);

    public abstract void update(T object);

    public IBasicDao<T> getTransientDao() {
        return transientDao;
    }

    public void setTransientDao(AbstractAgentObjectDao<T> transientDao) {
        this.transientDao = transientDao;
    }

    public IBasicDao<T> getReadDao() {
        if (transientDao instanceof NullDao) {
            return this;
        } else {
            return transientDao;
        }
    }
}
