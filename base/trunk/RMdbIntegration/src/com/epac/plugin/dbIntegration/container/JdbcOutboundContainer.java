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
package com.epac.plugin.dbIntegration.container;

import net.form105.rm.base.container.PropertiesContainer;

import org.picocontainer.Startable;

import com.epac.plugin.dbIntegration.mapping.JdbcOutboundHandler;

public class JdbcOutboundContainer implements Startable {
	
	private DBConnectionPoolContainer _poolContainer;
	private PropertiesContainer _propContainer;
	private JdbcOutboundHandler _outboundHandler;
	
	public JdbcOutboundContainer(DBConnectionPoolContainer poolContainer, PropertiesContainer propContainer) {
		_propContainer = propContainer;
		_poolContainer = _poolContainer;
	}

	@Override
	public void start() {
		_outboundHandler = new JdbcOutboundHandler();
	}

	@Override
	public void stop() {
		_outboundHandler = null;

	}
	
	public JdbcOutboundHandler getHandler() {
		return _outboundHandler;
	}

}
