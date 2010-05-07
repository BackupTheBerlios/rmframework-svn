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
package net.form105.rm.base.container;

import net.form105.rm.base.dao.resource.IDao;
import net.form105.rm.base.dao.resource.ResourceJcrDao;
import net.form105.rm.base.model.Resource;

/**
 * Creates the ResourceMasterDao and registers the sub daos to the master
 * @author heikok
 *
 */
public class JcrDaoContainer extends AbstractContainer {
	
	private JcrContainer jcrContainer;
	private ResourceJcrDao resourceDao;
	
	public JcrDaoContainer(JcrContainer jcrContainer) {
		this.jcrContainer = jcrContainer;
	}

	@Override
	public void start() {
		resourceDao = new ResourceJcrDao(jcrContainer.getDB());
	}

	@Override
	public void stop() {
		

	}
	
	public  IDao<Resource> getResourceDao() {
		return resourceDao;
	}

}
