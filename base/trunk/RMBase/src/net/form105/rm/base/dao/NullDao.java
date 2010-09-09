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

import net.form105.rm.base.model.AgentObject;

public class NullDao<T extends AgentObject> implements IBasicDao<T> {

    @Override
    public void delete(T object) {
        // do nothing
    }

    @Override
    public List<T> findAll() {
    	return null;
    }

    @Override
    public T findByElementId(String elementId) {
    	// supported by persistence dao
    	return null;
    }

    @Override
    public T findById(Long id) {
    	// supported by persistence dao
    	return null;
    }

    @Override
    public T merge(T object) {
    	return null;
    }

    @Override
    public void save(T object) {
        // do nothing
    }

    @Override
    public void saveOrUpdate(T object) {
        // do nothing
    }

    @Override
    public void update(T object) {
        // do nothing
    }

}
