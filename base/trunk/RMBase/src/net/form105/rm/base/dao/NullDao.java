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
package net.form105.rm.base.dao;

import java.util.List;

import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.model.AgentObject;

import com.db4o.foundation.NotSupportedException;

public class NullDao<T extends AgentObject> extends AbstractAgentObjectDao<T> {

    @Override
    public void delete(T object) {
        throw new NotSupportedException();
    }

    @Override
    public List<T> findAll() {
        throw new NotSupportedException();
    }

    @Override
    public T findByElementId(String elementId) {
        throw new NotSupportedException();
    }

    @Override
    public T findById(Long id) {
        throw new NotSupportedException();
    }

    @Override
    public T merge(T object) {
        throw new NotSupportedException();
    }

    @Override
    public void save(T object) {
        throw new NotSupportedException();
    }

    @Override
    public void saveOrUpdate(T object) {
        throw new NotSupportedException(); 
    }

    @Override
    public void update(T object) {
        throw new NotSupportedException();
    }

}
