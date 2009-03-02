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

import net.form105.rm.base.db.dialect.UniversalDialect;
import net.form105.rm.base.db.statement.UpdateStatement;
import net.form105.rm.server.db.entity.PaceOrderLineDbEntity;

import org.apache.log4j.Logger;
import org.junit.Test;


public class PaceOrderLineDbEntityTest {
	public static Logger logger = Logger.getLogger(PaceOrderLineDbEntityTest.class);
	
	@Test
	public void updateOrderLine() {
		PaceOrderLineDbEntity entity = new PaceOrderLineDbEntity();
		entity.setOrderLineId("158766");
		entity.setPartId("PA28034");
		entity.setQuantity(101);
		UniversalDialect dialect = new UniversalDialect(entity);
		UpdateStatement statement = new UpdateStatement();
		String updateStatement = statement.getStatement(dialect);
		logger.info(updateStatement);
	}

}
