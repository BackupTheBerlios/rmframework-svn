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

import org.picocontainer.Startable;

import net.form105.rm.server.ant.model.Workflow;

public class WorkflowContainer implements Startable {

	private Map<String, Workflow> workflowMap;

	public WorkflowContainer() {

	}

	@Override
	public void start() {
		workflowMap = new HashMap<String, Workflow>();
	}

	@Override
	public void stop() {
	}

	public void addWorkflow(Workflow workflow) {
		workflowMap.put(workflow.getId(), workflow);
	}

	public void removeWorkflow(Workflow workflow) {
		workflowMap.remove(workflow.getId());
	}

	public Workflow getWorkflowById(String id) {
		return workflowMap.get(id);
	}

}
