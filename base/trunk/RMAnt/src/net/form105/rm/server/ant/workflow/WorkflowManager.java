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

import net.form105.rm.server.ant.model.NullWorkflow;
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
	
	public Workflow getWorkflowByAttributeValue(String attributeId, String attributeValue) {
		for (Workflow workflow : map.getAllWorkflows()) {
			if (workflow.getAttributeById(attributeId).getValue().equals(attributeValue)) {
				return workflow;
			}
		}
		return new NullWorkflow();
	}
}
