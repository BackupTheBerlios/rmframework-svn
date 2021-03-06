/*
 * Copyright (c) 2010, form105 Heiko Kundlacz
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
package net.form105.rm.base.rmi;

import net.form105.rm.base.model.IAgentObject;
import net.form105.rm.base.model.workflow.Workflow;

import org.apache.log4j.Logger;

public class RMICallbackClient implements ICallbackClient {
	
	public static Logger logger = Logger.getLogger(RMICallbackClient.class);

	@Override
	public void add(IAgentObject agentObject) {
		if (agentObject instanceof Workflow) {
			logger.info("client notified: ADD");
		}
	}

	@Override
	public void remove(IAgentObject agentObject) {
		if (agentObject instanceof Workflow) {
			logger.info("client notified: REMOVE");
		}		
	}

	@Override
	public void update(IAgentObject agentObject) {
		if (agentObject instanceof Workflow) {
			logger.info("client notified: UPDATE");
		}		
	}
}
