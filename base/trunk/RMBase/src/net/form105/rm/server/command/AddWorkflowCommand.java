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
package net.form105.rm.server.command;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.model.workflow.Workflow;
import net.form105.rm.base.model.workflow.WorkflowManager;

public class AddWorkflowCommand extends AbstractCommand {
	
	private Workflow workflow;
	
	public AddWorkflowCommand(Workflow workflow) {
		this.workflow = workflow;
	}

	@Override
	public void execute() throws RMException {
		WorkflowManager manager = (WorkflowManager) Agent.getComponentById("workflowManager");
		manager.addWorkflow(workflow);
	}
}
