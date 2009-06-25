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

import net.form105.rm.base.command.CommandHandler;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;
import net.form105.rm.server.command.SaveResourceCommand;

public class CreateResourceService extends AbstractService {
	
	private static final long serialVersionUID = 1L;
	
	private ServiceArgument argument = new ServiceArgument();

	@Override
	public void execute() throws Exception {
		CommandHandler<Resource> handler = new CommandHandler<Resource>();
		SaveResourceCommand command = new SaveResourceCommand(argument.resource);
		handler.execute(command);
	}
	
	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public Resource resource;
	}

	@Override
	public ServiceArgument getArgument() {
		return argument;
	}

}
