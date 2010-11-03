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
import net.form105.rm.server.ant.container.TaskMapContainer;
import net.form105.rm.server.ant.container.WorkflowContainer;
import net.form105.rm.server.ant.model.Task;
import net.form105.rm.server.ant.model.Workflow;

/**
 * A command which adds a task to the workflow. The task must be added to the taskMap and the list in the workflow. 
 * @author heikok
 *
 */
public class AddTaskCommand extends AbstractCommand {
	
	private Task task;
	private String workflowId;
	
	public AddTaskCommand(String workflowId, Task task) {
		this.task = task;
		this.workflowId = workflowId;
	}

	@Override
	public void execute() throws RMException {
		TaskMapContainer taskContainer = (TaskMapContainer) Agent.getComponentById("taskMap");
		taskContainer.addTask(task);
		WorkflowContainer wfContainer = (WorkflowContainer) Agent.getComponentById("workflowMap");
		Workflow wf = wfContainer.getWorkflowById(workflowId);
		wf.addTask(task);
	}

}
