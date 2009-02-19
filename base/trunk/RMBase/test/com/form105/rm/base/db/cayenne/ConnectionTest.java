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
package com.form105.rm.base.db.cayenne;

import java.util.List;

import net.form105.rm.base.db.MappingTable;
import net.form105.rm.base.model.Resource;
import net.form105.rm.server.model.ResourceElement;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.query.SelectQuery;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


public class ConnectionTest {

	public static Logger logger = Logger.getLogger(ConnectionTest.class);

	@Before
	public void setUp() {
		
	}

	@Test
	public void runTest() {
		
		// Configuration.initializeSharedConfiguration(config);
		DataContext context = DataContext.createDataContext();
		SelectQuery query = new SelectQuery(ResourceElement.class);

		List<ResourceElement> resourceElements = context.performQuery(query);
		logger.info("Results: " + resourceElements.size());

		for (ResourceElement element : resourceElements) {
			logger.info(element.getElementId());

		}
		
		
		Resource resource = new Resource("bcrXXX", "Name of bcrXXX", "Type of bcr XXX");
		createResource(resource, context);

	}
	
	
	public void createResource(Resource resource, DataContext context) {
		ResourceElement resElement = context.newObject(ResourceElement.class);
		resElement.setElementId(resource.getElementId());
		resElement.setElementType(resource.getType());
		resElement.setElementName(resource.getName());
		
		context.commitChanges();
		
		
	}

}
