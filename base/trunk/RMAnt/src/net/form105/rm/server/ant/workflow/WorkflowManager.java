/*
 * Copyright (c) 2011, form105 Heiko Kundlacz
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
package net.form105.rm.server.ant.workflow;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.attribute.AbstractAttribute;
import net.form105.rm.server.ant.model.NullWorkflow;
import net.form105.rm.server.ant.model.Task;
import net.form105.rm.server.ant.model.Workflow;

/**
 * A manager which handles all requests and direct actions on a workflow
 * @author heikok
 *
 */

public class WorkflowManager {
	
	private WorkflowMap map;
	
	public WorkflowManager(WorkflowMap map) {
		this.map = map;
	}
	
	public List<Workflow> getWorkflowByAttributeValue(String attributeId, String attributeValue) {
		List<Workflow> workflows = new ArrayList<Workflow>();
		for (Workflow workflow : map.getAllWorkflows()) {
			if (workflow.getAttributeById(attributeId).getValue().equals(attributeValue)) {
				workflows.add(workflow);
			}
		}
		return workflows;
	}
	
	public void addWorkflow(Workflow workflow) {
		map.addWorkflow(workflow);
	}
	
	public void removeWorkflow(Workflow workflow) {
		map.removeWorkflow(workflow);
	}
	
	/**
	 * Sets a attribute of the workflow. The attribute value will be updated,
	 * if the attribute with the specified id already exists 
	 * @param <T>
	 * @param attribute
	 */
	@SuppressWarnings("unchecked")
	public <T> void updateAttribute(String workflowId, AbstractAttribute<T> attribute) {
		Workflow workflow = map.getWorkflowById(workflowId);
		AbstractAttribute<T> existingAttribute = (AbstractAttribute<T>) workflow.getAttributeById(attribute.getElementId()); 
		if (existingAttribute == null) {
			workflow.addAttribute(attribute);
		} else {
			existingAttribute.setValue(attribute.getValue());
		}
	}
	
	public void addTask(Workflow workflow, Task task) {
		workflow.addTask(task);
	}
	
	public Workflow getWorkflowById(String id) {
		return map.getWorkflowById(id);
	}
	
	
}
