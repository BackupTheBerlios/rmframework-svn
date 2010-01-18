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
package com.epac.plugin.dbIntegration.mapping;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.Agent;
import net.form105.rm.base.exception.RMSqlException;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.server.i18n.BaseI18NMessage;

import org.apache.log4j.Logger;

import com.epac.plugin.dbIntegration.container.DBConnectionPoolContainer;
import com.epac.plugin.dbIntegration.mapping.action.ActionType;
import com.epac.plugin.dbIntegration.mapping.action.DeleteAction;
import com.epac.plugin.dbIntegration.mapping.action.IJdbcAction;
import com.epac.plugin.dbIntegration.mapping.action.InsertAction;
import com.epac.plugin.dbIntegration.mapping.action.JdbcResult;
import com.epac.plugin.dbIntegration.mapping.action.ResetTableAction;
import com.epac.plugin.dbIntegration.mapping.action.SelectAllAction;
import com.epac.plugin.dbIntegration.mapping.action.SelectByConstrainAction;
import com.epac.plugin.dbIntegration.mapping.action.UpdateAction;

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
		addAction(ActionType.RESETTABLE, new ResetTableAction());
	}

	public IResult<AbstractDBEntity> executeAction(AbstractDBEntity entity, ActionType type) throws RMSqlException {
		IResult<AbstractDBEntity> result = new JdbcResult();
		IJdbcAction action = actionMap.get(type);
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			List<AbstractDBEntity> list = action.execute(entity, connection);
			result.setResultList(list);
			result.setStatus(ResultStatus.SUCCESS);
			connection.setAutoCommit(true);
		} catch (SQLException sqlEx) {
			logger.info("Exception occured with action: "+action.getId());
			if (connection != null)
				try {
					connection.rollback();
				} catch (SQLException e) {
					logger.error("Tried to rollback transacton, but unsuccessfully ended!");
				}
			throw new RMSqlException(new BaseI18NMessage(), "exception.sql.base", new String[] {sqlEx.getMessage()}, sqlEx);
		}

		return result;
	}

	public Connection getConnection() throws SQLException {
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
