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

public abstract class AbstractDao<T> implements IDao<T> {
	
	/* (non-Javadoc)
	 * @see net.form105.rm.base.dao.resource.IDao#delete(T)
	 */
	public abstract void delete(T object);

    /* (non-Javadoc)
	 * @see net.form105.rm.base.dao.resource.IDao#findAll()
	 */
    public abstract List<T> findAll();

    /* (non-Javadoc)
	 * @see net.form105.rm.base.dao.resource.IDao#findByElementId(java.lang.String)
	 */
    public abstract T findByElementId(String elementId);

    /* (non-Javadoc)
	 * @see net.form105.rm.base.dao.resource.IDao#findById(java.lang.Long)
	 */
    public abstract T findById(Long id);


    /* (non-Javadoc)
	 * @see net.form105.rm.base.dao.resource.IDao#save(T)
	 */
    public abstract void save(T object);

    /* (non-Javadoc)
	 * @see net.form105.rm.base.dao.resource.IDao#saveOrUpdate(T)
	 */
    public abstract void saveOrUpdate(T object);

    /* (non-Javadoc)
	 * @see net.form105.rm.base.dao.resource.IDao#update(T)
	 */
    public abstract void update(T object);
    
    /**
     * Checks if this Dao is the preferred dao use for getting the data
     * @return
     */
    public abstract boolean isReadDao();

}
