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
package net.form105.rm.server.ant.command;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.server.ant.model.Workflow;
import net.form105.rm.server.ant.workflow.WorkflowManager;

public class AddWorkflowCommand extends AbstractCommand {
	
	private String id;
	private String name; 
	private String type;
	
	public AddWorkflowCommand(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	@Override
	public void execute() throws RMException {
		WorkflowManager wfManager = (WorkflowManager) Agent.getComponentById("workflowManager");
		wfManager.addWorkflow(new Workflow(id, name, type));
	}

}
