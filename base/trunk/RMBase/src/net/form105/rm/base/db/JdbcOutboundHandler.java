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
package net.form105.rm.base.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.Agent;
import net.form105.rm.base.container.DBConnectionPoolContainer;
import net.form105.rm.base.db.action.ActionType;
import net.form105.rm.base.db.action.DeleteAction;
import net.form105.rm.base.db.action.IJdbcAction;
import net.form105.rm.base.db.action.InsertAction;
import net.form105.rm.base.db.action.JdbcResult;
import net.form105.rm.base.db.action.SelectAllAction;
import net.form105.rm.base.db.action.SelectByConstrainAction;
import net.form105.rm.base.db.action.UpdateAction;
import net.form105.rm.base.exception.RMSqlException;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.server.i18n.BaseI18NMessage;

import org.apache.log4j.Logger;

/**
 * This outbound handler executes an action which is one that acts on a database connected via
 * jdbc. The actions are registered in a map and can be accessed by an action type. All data required
 * for execution is provided by an {@link AbstractDBEntity}. The execution wraps {@link SQLException} to 
 * a {@link RMSqlException}.
 * @author heikok
 *
 */
public class JdbcOutboundHandler {

	public static Logger logger = Logger.getLogger(JdbcOutboundHandler.class);

	private Map<ActionType, IJdbcAction> actionMap = new HashMap<ActionType, IJdbcAction>();

	public JdbcOutboundHandler() {
		addAction(ActionType.SELECTALL, new SelectAllAction());
		addAction(ActionType.INSERT, new InsertAction());
		addAction(ActionType.DELETE, new DeleteAction());
		addAction(ActionType.UPDATE, new UpdateAction());
		addAction(ActionType.SELECT_BY_CONSTRAIN, new SelectByConstrainAction());
	}

	public IResult<AbstractDBEntity> executeAction(AbstractDBEntity entity, ActionType type) throws RMSqlException {
		IResult<AbstractDBEntity> result = new JdbcResult();
		IJdbcAction action = actionMap.get(type);

		try {
			List<AbstractDBEntity> list = action.execute(entity, getConnection());
			result.setResultList(list);
			result.setStatus(ResultStatus.SUCCESS);
		} catch (SQLException sqlEx) {
			throw new RMSqlException(new BaseI18NMessage(), "exception.sql.base", new String[] {sqlEx.getMessage()}, sqlEx);
		}

		return result;
	}

	protected Connection getConnection() throws SQLException {
		DBConnectionPoolContainer connectionContainer = (DBConnectionPoolContainer) Agent
				.getContainer(DBConnectionPoolContainer.class);
		Connection connection = connectionContainer.getDefaultConnection();
		return connection;
	}

	public void addAction(ActionType type, IJdbcAction action) {
		actionMap.put(type, action);
	}

	public IJdbcAction getAction(ActionType type) {
		return actionMap.get(type);
	}
	
	public void commitConnection() {
		try {
			getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
