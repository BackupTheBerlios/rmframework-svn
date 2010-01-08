/*
 * Copyright (c) 2009, form105 Heiko Kundlacz
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

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epac.plugin.dbIntegration.mapping.dialect.UniversalDialect;
import com.epac.plugin.dbIntegration.mapping.statement.DeleteStatement;
import com.epac.plugin.dbIntegration.mapping.statement.InsertStatement;
import com.epac.plugin.dbIntegration.mapping.statement.ResetTableStatement;
import com.epac.plugin.dbIntegration.mapping.statement.SelectStatement;
import com.epac.plugin.dbIntegration.mapping.statement.UpdateStatement;

/**
 * Compares each statement with the expected results. The statements are sent to the database
 * @author heikok
 *
 */
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
		StringBuilder sql = select.getStatement(dialect);
		//logger.info(sql);
		Assert.assertEquals("SELECT \"resource #\",\"dbElementId\",\"dbElementType\",\"dbElementInteger\",\"dbElementFloat\" FROM resourceElement ", sql.toString());
	}
	
	@Test
	public void updateStatement() {
		UniversalDialect dialect = new UniversalDialect(entity);
		UpdateStatement update = new UpdateStatement();
		String sql = "UPDATE resourceElement SET  \"dbElementId\"='id001', \"dbElementType\"='resourceType', \"dbElementInteger\"=NULL, \"dbElementFloat\"=15.0000326 WHERE \"resource #\"=NULL";
		junit.framework.Assert.assertEquals(sql, update.getStatement(dialect).toString());
	}
	
	@Test
	public void deleteStatement() {
		entity.setObjectId(1);
		UniversalDialect dialect = new UniversalDialect(entity);
		DeleteStatement delete = new DeleteStatement();
		String sql = "DELETE resourceElement WHERE \"resource #\"=1";
		Assert.assertEquals(sql, delete.getStatement(dialect).toString());
	}
	
	@Test
	public void insertStatement() {
		UniversalDialect dialect = new UniversalDialect(entity);
		InsertStatement insert = new InsertStatement();
		String sql = "INSERT INTO resourceElement (\"dbElementId\",\"dbElementType\",\"dbElementInteger\",\"dbElementFloat\" ) VALUES('id001','resourceType',NULL,15.0000326)";
		Assert.assertEquals(sql, insert.getStatement(dialect).toString());
	}
	
	@Test
	public void resetTableStatement() {
		UniversalDialect dialect = new UniversalDialect(entity);
		ResetTableStatement stmt = new ResetTableStatement();
		String sql = "DELETE FROM resourceElement";
		Assert.assertEquals(sql, stmt.getStatement(dialect).toString());
	}

}
