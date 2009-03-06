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
package net.form105.rm.base.db.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.statement.SelectStatement;

public class SelectByConstrainAction extends AbstractSelectAction {

	private final String ID = "SELECT_BY_CONSTRAIN_ACTION";

	@Override
	public List<AbstractDBEntity> execute(AbstractDBEntity entity, Connection connection) throws SQLException {
		SelectStatement statement = new SelectStatement();
		return executeStatement(statement, entity, connection);
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public ActionType getRegistrationName() {
		// TODO Auto-generated method stub
		return null;
	}

}
