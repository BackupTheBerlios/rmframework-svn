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
package net.form105.rm.server.query.db;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.container.JdbcOutboundContainer;
import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.JdbcOutboundHandler;
import net.form105.rm.base.db.action.ActionType;
import net.form105.rm.base.query.AbstractSimpleQuery;
import net.form105.rm.base.service.IResult;

public class EntityQuery extends AbstractSimpleQuery<AbstractDBEntity> {
	
	private AbstractDBEntity _entity;
	
	public EntityQuery(AbstractDBEntity entity) {
		this._entity = entity;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public List<AbstractDBEntity> execute() {
		JdbcOutboundContainer container = (JdbcOutboundContainer) Agent.getContainer(JdbcOutboundContainer.class);
		JdbcOutboundHandler handler = container.getHandler();
		ActionType actionType;
		if (_entity.equals("")) { 
			actionType = ActionType.SELECTALL;
		} else {
			actionType = ActionType.SELECT_BY_CONSTRAIN;
		}
		
		IResult<AbstractDBEntity> result = handler.executeAction(_entity, actionType);
		return result.getResultList();
	}

}
