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
package com.form105.rm.base.query;

import java.util.Collection;

import org.junit.Test;

import net.form105.rm.base.dao.resource.AbstractResourceDao;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.query.FindAllDaoQuery;
import net.form105.rm.base.service.IResult;

public class FindAllResourcesTest extends AbstractRemoteTest<Resource> {
	
	@Test
	public void findAllResources() {
		FindAllDaoQuery<Resource> query = new FindAllDaoQuery<Resource>(AbstractResourceDao.class);
		IResult<Resource> userResult = doQuery(query);
		Collection<Resource> resources = userResult.getResultList();
		logger.info("Found resources, amount: "+resources.size());
		for (Resource resource : resources) {
			logger.info("Found resource: "+resource.getElementId());
		}
	}

}
