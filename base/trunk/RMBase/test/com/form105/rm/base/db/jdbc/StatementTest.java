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

import net.form105.rm.base.db.dialect.UniversalDialect;
import net.form105.rm.base.db.statement.DeleteStatement;
import net.form105.rm.base.db.statement.InsertStatement;
import net.form105.rm.base.db.statement.SelectStatement;
import net.form105.rm.base.db.statement.UpdateStatement;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StatementTest {
	
public static Logger logger = Logger.getLogger(UniversalDialectTest.class);
	
	private ResourceDBEntityTest entity;
	
	@Before
	public void setup() {
		entity = new ResourceDBEntityTest();
		entity.setElementId("id001");
		entity.setElementType("resourceType");
		entity.setElementFloat(new BigDecimal("15.0000326"));
	}
	
	@Test
	public void selectStatement() {
		UniversalDialect dialect = new UniversalDialect(entity);
		SelectStatement select = new SelectStatement();
		String sql = select.getStatement(dialect);
		Assert.assertEquals("SELECT \"resource #\",\"dbElementId\",\"dbElementType\",\"dbElementInteger\",\"dbElementFloat\" FROM resourceElement", sql);
	}
	
	@Test
	public void updateStatement() {
		UniversalDialect dialect = new UniversalDialect(entity);
		UpdateStatement update = new UpdateStatement();
		String sql = "UPDATE resourceElement SET  \"dbElementId\"='id001', \"dbElementType\"='resourceType', \"dbElementInteger\"=NULL, \"dbElementFloat\"=15.0000326 WHERE \"resource #\"=NULL";
		Assert.assertEquals(sql, update.getStatement(dialect));
	}
	
	@Test
	public void deleteStatement() {
		entity.setObjectId(001);
		UniversalDialect dialect = new UniversalDialect(entity);
		DeleteStatement delete = new DeleteStatement();
		String sql = "DELETE resourceElement WHERE \"resource #\"='objectId001'";
		Assert.assertEquals(sql, delete.getStatement(dialect));
	}
	
	@Test
	public void insertStatement() {
		UniversalDialect dialect = new UniversalDialect(entity);
		InsertStatement insert = new InsertStatement();
		String sql = "INSERT INTO resourceElement (\"resource #\",\"dbElementId\",\"dbElementType\",\"dbElementInteger\",\"dbElementFloat\" ) VALUES(NULL,'id001','resourceType',NULL,15.0000326)";
		Assert.assertEquals(sql, insert.getStatement(dialect));
	}

}
