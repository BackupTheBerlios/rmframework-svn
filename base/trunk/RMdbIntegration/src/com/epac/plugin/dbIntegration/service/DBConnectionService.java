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
package com.epac.plugin.dbIntegration.service;

import java.sql.Connection;

import net.form105.rm.base.Agent;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

import com.epac.plugin.dbIntegration.container.JdbcOutboundContainer;
import com.epac.plugin.dbIntegration.mapping.JdbcOutboundHandler;

public class DBConnectionService extends AbstractService {
	
	private static final long serialVersionUID = 1L;
	private ServiceArgument argument = new ServiceArgument();

	@Override
	public void execute() throws Exception {
		JdbcOutboundContainer container = (JdbcOutboundContainer) Agent.getContainer(JdbcOutboundContainer.class);
		JdbcOutboundHandler cHandler = container.getHandler();
		Connection connection = cHandler.getConnection();
		logger.info("Connection is: "+connection);
		//connection.commit();
		//connection.close();
	}

	@Override
	public ServiceArgument getArgument() {
		return argument;
	}
	
	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
	}

}
