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
package com.epac.plugin.dbIntegration.command;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.exception.RMException;

import com.epac.plugin.dbIntegration.base.container.JdbcOutboundContainer;
import com.epac.plugin.dbIntegration.mapping.AbstractDBEntity;
import com.epac.plugin.dbIntegration.mapping.JdbcOutboundHandler;
import com.epac.plugin.dbIntegration.mapping.action.ActionType;

public class ExecuteEntityCommand extends AbstractCommand {

	private final String ID = "EXECUTE_ENTITY_COMMAND";

	private AbstractDBEntity _entity;
	private ActionType _actionType;

	public ExecuteEntityCommand(AbstractDBEntity entity, ActionType actionType) {
		_entity = entity;
		_actionType = actionType;
	}

	@Override
	public void execute() throws RMException {
		JdbcOutboundContainer container = (JdbcOutboundContainer) Agent.getContainer(JdbcOutboundContainer.class);
		JdbcOutboundHandler handler = container.getHandler();
		handler.executeAction(_entity, _actionType);
	}

	@Override
	public String getId() {
		return ID;
	}

}
