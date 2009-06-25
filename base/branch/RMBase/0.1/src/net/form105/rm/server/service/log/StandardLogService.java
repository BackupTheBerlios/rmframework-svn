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
package net.form105.rm.server.service.log;

import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class StandardLogService extends AbstractService {
	
	private static final long serialVersionUID = 1L;
	
	protected static Logger logger = Logger.getLogger(StandardLogService.class);
	
	private ServiceArgument argument = new ServiceArgument();
	
	
	@Override
	public void execute() throws Exception {
		
		if (LogManager.exists(argument.category) == null) {
			logger.warn("Logger category doesn't exist: "+argument.category);
		}
		
		Logger fmOrderLogger = Logger.getLogger(argument.category);

		fmOrderLogger.info(argument.logMessage);
	}
	
	
	public ServiceArgument getArgument() {
		return argument;
	}
	
	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public String logMessage;
		public String category;
	}
}
