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
package net.form105.rm.server.service;

import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.container.BackgroundThreadContainer;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

import org.picocontainer.Startable;

public class StopServerService extends AbstractService {
	
	private static final long serialVersionUID = 1L;
	ServiceArgument argument = new ServiceArgument();

	@Override
	public void execute() throws Exception {
		Container.getInstance().stopAll();
	}
	
	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;		
	}

	@Override
	public ServiceArgument getArgument() {
		BackgroundThreadContainer container = (BackgroundThreadContainer) Agent.getContainer(BackgroundThreadContainer.class);
		container.stop();
		return argument;
	}

}
