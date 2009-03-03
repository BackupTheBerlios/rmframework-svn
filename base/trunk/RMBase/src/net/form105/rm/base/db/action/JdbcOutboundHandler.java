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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.Agent;
import net.form105.rm.base.container.DBConnectionPoolContainer;
import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;

import org.apache.log4j.Logger;

public class JdbcOutboundHandler {

	public static Logger logger = Logger.getLogger(JdbcOutboundHandler.class);
	
	private Map<ActionType, IJdbcAction> actionMap = new HashMap<ActionType, IJdbcAction>();
	
	public JdbcOutboundHandler() {
		actionMap.put(ActionType.SELECT, new SelectAction());
		actionMap.put(ActionType.INSERT, new InsertAction());
		actionMap.put(ActionType.DELETE, new DeleteAction());
		actionMap.put(ActionType.UPDATE, new UpdateAction());
	}
	
	public IResult<AbstractDBEntity> executeAction(AbstractDBEntity entity, ActionType type) {
		IResult<AbstractDBEntity> result = new JdbcResult();
		
		IJdbcAction action = actionMap.get(type);
		
		try {
			List<AbstractDBEntity> list = action.execute(entity, getConnection());
			result.setResultList(list);
			result.setStatus(ResultStatus.SUCCESS);
		} catch (SQLException e) {
			result.setException(e);
			result.setResultList(new ArrayList<AbstractDBEntity>());
			result.setStatus(ResultStatus.FAIL);
			logger.error(e,e);
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
	
	
}
