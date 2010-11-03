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
package net.form105.rm.server.ant.container;

import java.util.HashMap;
import java.util.Map;

import net.form105.rm.server.ant.model.Task;
import net.form105.rm.server.ant.model.Workflow;

import org.picocontainer.Startable;

public class TaskMapContainer implements Startable {

	private Map<String, Task> taskMap;
	private WorkflowContainer wfContainer;

	public TaskMapContainer(WorkflowContainer wfContainer) {
		this.wfContainer = wfContainer;
	}

	@Override
	public void start() {
		taskMap = new HashMap<String, Task>();
	}

	@Override
	public void stop() {
	}

	public void addTask(Task task) {
		taskMap.put(task.getElementId(), task);
	}

	public void removeTask(Task task) {
		taskMap.remove(task.getElementId());
		Workflow workflow = task.getParent();
		workflow.removeTask(task);
	}

	public WorkflowContainer getWorkflowContainer() {
		return wfContainer;
	}

}
