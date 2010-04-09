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
package com.epac.plugin.dbIntegration.jdbc;


import java.math.BigDecimal;

import net.form105.rm.base.query.AbstractRemoteTest;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.epac.plugin.dbIntegration.mapping.AbstractDBEntity;
import com.epac.plugin.dbIntegration.mapping.action.ActionType;
import com.epac.plugin.dbIntegration.query.EntityQuery;
import com.epac.plugin.dbIntegration.service.ExecuteEntityService;

/**
 * Writes 100 rows into the database and checks for results. The table will be reset
 * before and after the test
 * @author heikok
 *
 */
public class ExecuteEntityServiceTest extends AbstractRemoteTest<AbstractDBEntity> {
	
	public static Logger logger = Logger.getLogger(ExecuteEntityServiceTest.class);
	
	@Test
	public void databaseActionTest() {
		int cycle = 100;
		resetTable();
		insertBatch(cycle);
		Assert.assertEquals(cycle, selectResource());
		resetTable();
	}
	
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
	
	
	public int selectResource() {
		ResourceDBEntityTest entity = new ResourceDBEntityTest();
		//entity.setConstraint("WHERE \"dbElementId\" LIKE 'bcr%'");
		
		EntityQuery query = new EntityQuery(entity);
		IResult<AbstractDBEntity> result = doQuery(query);
		
		Assert.assertEquals(ResultStatus.SUCCESS, result.getStatus());
		return result.getResultList().size();
	}
	
	
	public void insertBatch(int rows) {
		int max = rows;
		
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
	
	
	public void resetTable() {
		ResourceDBEntityTest entity = new ResourceDBEntityTest();
		ExecuteEntityService service = new ExecuteEntityService();
		ExecuteEntityService.ServiceArgument argument = service.getArgument();
		argument.entity = entity;
		argument.actionType = ActionType.RESETTABLE;
		doService(service);
	}
	
}
