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

import net.form105.rm.base.dao.resource.ResourceMasterDao;

/**
 * Creates the ResourceMasterDao and registers the sub daos to the master
 * @author heikok
 *
 */
public class JcrDaoContainer extends AbstractContainer {
	
	private JcrContainer jcrContainer;
	private ResourceMasterDao resourceMasterDao;
	
	public JcrDaoContainer(JcrContainer jcrContainer) {
		this.jcrContainer = jcrContainer;
	}

	@Override
	public void start() {
		resourceMasterDao = new ResourceMasterDao(jcrContainer.getDB());

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
	
	public  ResourceMasterDao getResourceMasterDao() {
		return resourceMasterDao;
	}

}
