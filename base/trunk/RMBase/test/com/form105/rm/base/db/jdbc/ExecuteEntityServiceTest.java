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
package com.form105.rm.base.db.jdbc;


import java.math.BigDecimal;
import java.util.List;

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.action.ActionType;
import net.form105.rm.base.service.IResult;
import net.form105.rm.server.query.db.EntityQuery;
import net.form105.rm.server.service.ExecuteEntityService;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class ExecuteEntityServiceTest extends AbstractRemoteTest<AbstractDBEntity> {
	
	public static Logger logger = Logger.getLogger(ExecuteEntityServiceTest.class);
	
	//@Test
	public void executeInsert() {
		String time = String.valueOf(System.currentTimeMillis());
		ExecuteEntityService service = new ExecuteEntityService();
		ExecuteEntityService.ServiceArgument argument = service.getArgument();
		
		ResourceDBEntityTest entity = new ResourceDBEntityTest();
		entity.setElementId("id"+time);
		entity.setElementType("randomEntry");
		entity.setElementFloat(new BigDecimal(1.1));
		entity.setElementInteger(66);
		
		argument.actionType = ActionType.INSERT;
		argument.entity = entity;
		
		IResult<AbstractDBEntity> result = doService(service);
	}
	
	//@Test
	public void selectResource() {
		ResourceDBEntityTest entity = new ResourceDBEntityTest();
		//entity.setConstraint("WHERE \"dbElementId\" LIKE 'bcr%'");
		
		EntityQuery query = new EntityQuery(entity);
		IResult<AbstractDBEntity> result = doQuery(query);
		
		//Assert.assertEquals(ResultStatus.SUCCESS, result.getStatus());
		logger.info("rows got: "+result.getResultList().size());
		
		/*for (AbstractDBEntity resultEntity : result.getResultList()) {
			StringBuffer sb = new StringBuffer();
			ResourceDBEntityTest finalEntity = (ResourceDBEntityTest) resultEntity;
			sb.append(finalEntity.getObjectId()).append(":");
			sb.append(finalEntity.getElementId()).append(":");
			sb.append(finalEntity.getElementType()).append(":");
			sb.append(finalEntity.getElementFloat()).append(":");
			sb.append(finalEntity.getElementInteger()).append(":");
		}*/
	}
	
	@Test
	public void insertBatch() {
		int max = 10000;
		
		ResourceDBEntityTest entity = new ResourceDBEntityTest();
		
		for (int i = 0; i < max; i++) {
			entity.setElementId("bcr"+i);
			entity.setElementType("basic");
			entity.setElementInteger(i);
			Double value = (double) 1/(i+1);
			entity.setElementFloat(new BigDecimal(value));
			
			ExecuteEntityService service = new ExecuteEntityService();
			ExecuteEntityService.ServiceArgument argument = service.getArgument();
			argument.entity = entity;
			argument.actionType = ActionType.INSERT;
			
			doService(service);
		}
	}
	
	//@Test
	public void deleteAll() {
		ResourceDBEntityTest qEntity = new ResourceDBEntityTest();
		
		EntityQuery query = new EntityQuery(qEntity);
		IResult<AbstractDBEntity> result = doQuery(query);
		List<AbstractDBEntity> list = result.getResultList();
		for (AbstractDBEntity entity : list) {
			ResourceDBEntityTest resEntity = (ResourceDBEntityTest) entity;
			logger.info(resEntity.getObjectId());
		}
		
		ExecuteEntityService service = new ExecuteEntityService();
		ExecuteEntityService.ServiceArgument argument = service.getArgument();
		
		for (AbstractDBEntity entity : list) {
			argument.entity = entity;
			argument.actionType = ActionType.DELETE;
			//doService(service);
		}
		
	}

	public void basicTest() {
		Double value = 1/3d;
		BigDecimal bi = new BigDecimal(value);
		logger.info(bi+":"+value);
	}
	
	

}
