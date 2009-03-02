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

import junit.framework.Assert;

import net.form105.rm.base.db.dialect.UniversalDialect;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


public class UniversalDialectTest {
	
	public static Logger logger = Logger.getLogger(UniversalDialectTest.class);
	
	private ResourceDBEntityTest entity;
	
	@Before
	public void setup() {
		entity = new ResourceDBEntityTest();
		entity.setElementId("id001");
		entity.setElementType("resourceType");
		//entity.setElementInteger(15);
		entity.setElementFloat(new BigDecimal("15.0000326"));
	}
	
	@Test
	public void univeralDialectDelemitedFieldValuesTest() {
		UniversalDialect dialect = new UniversalDialect(entity);
		logger.info("String result from getDelemitedFieldValues(): "+dialect.getDelemitedFieldValues());
		Assert.assertEquals("NULL,'id001','resourceType',NULL,15.0000326", dialect.getDelemitedFieldValues());
	}
	
	@Test
	public void universalDialectFieldAssignmentPartTest() {
		UniversalDialect dialect = new UniversalDialect(entity);
		logger.info("String result form getFieldAssignmentPart: "+dialect.getFieldAssignmentPart());
		Assert.assertEquals(" \"resource #\"=NULL, \"dbElementId\"='id001', \"dbElementType\"='resourceType', \"dbElementInteger\"=NULL, \"dbElementFloat\"=15.0000326", dialect.getFieldAssignmentPart());
	}
	
	@Test
	public void universalDialectFieldPartTest() {
		UniversalDialect dialect = new UniversalDialect(entity);
		logger.info("String result from getFieldPart: "+dialect.getFieldPart());
		Assert.assertEquals("\"resource #\",\"dbElementId\",\"dbElementType\",\"dbElementInteger\",\"dbElementFloat\"", dialect.getFieldPart());
	}
	
	@Test
	public void universalDialect() {
		UniversalDialect dialect = new UniversalDialect(entity);
		logger.info("String result from getFieldPart: "+dialect.getIdSelectionPart());
		Assert.assertEquals("\"resource #\",\"dbElementId\",\"dbElementType\",\"dbElementInteger\",\"dbElementFloat\"", dialect.getFieldPart());
	}
	

}
