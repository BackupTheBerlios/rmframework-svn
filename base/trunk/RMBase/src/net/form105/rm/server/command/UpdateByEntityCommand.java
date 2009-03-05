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
package net.form105.rm.server.command;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.container.JdbcOutboundContainer;
import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.JdbcOutboundHandler;
import net.form105.rm.base.db.action.ActionType;
import net.form105.rm.base.exception.RMException;

import org.apache.log4j.Logger;

public class UpdateByEntityCommand extends AbstractCommand {
	
	public static Logger logger = Logger.getLogger(UpdateByEntityCommand.class);
	
	private final String ID = "INSERT_BY_ENTITY_COMMAND";
	
	private AbstractDBEntity _entity;
	
	public UpdateByEntityCommand(AbstractDBEntity entity) {
		_entity = entity;
	}

	@Override
	public void execute() throws RMException {
		JdbcOutboundContainer container = (JdbcOutboundContainer) Agent.getContainer(JdbcOutboundContainer.class);
		JdbcOutboundHandler handler = container.getHandler();
		handler.executeAction(_entity, ActionType.UPDATE);
	}

	@Override
	public String getId() {
		return ID;
	}

}
