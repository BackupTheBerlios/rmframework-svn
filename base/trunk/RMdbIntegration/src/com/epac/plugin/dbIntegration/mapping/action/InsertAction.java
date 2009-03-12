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
package com.epac.plugin.dbIntegration.mapping.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epac.plugin.dbIntegration.mapping.AbstractDBEntity;
import com.epac.plugin.dbIntegration.mapping.statement.InsertStatement;

public class InsertAction implements IJdbcAction {
	
	public static Logger logger = Logger.getLogger(InsertAction.class);
	
	private final String ID = "INSERT_BY_STATEMENT_ACTION";

	@Override
	public List<AbstractDBEntity> execute(AbstractDBEntity entity, Connection connection) throws SQLException {
		InsertStatement insertStmt = new InsertStatement();
		StringBuilder sql = insertStmt.getStatement(entity.getDialect());
		PreparedStatement stmt = connection.prepareStatement(sql.toString());
		logger.info("Execute statement update");
		stmt.executeUpdate();
		stmt.close();
		return new ArrayList<AbstractDBEntity>();
	}

	@Override
	public String getId() {
		return ID;
	}
}
