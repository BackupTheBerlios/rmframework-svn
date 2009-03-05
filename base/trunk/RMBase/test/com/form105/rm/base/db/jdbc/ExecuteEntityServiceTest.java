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

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.action.ActionType;
import net.form105.rm.base.service.IResult;
import net.form105.rm.server.service.ExecuteEntityService;

import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class ExecuteEntityServiceTest extends AbstractRemoteTest<AbstractDBEntity> {
	
	@Test
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

}
