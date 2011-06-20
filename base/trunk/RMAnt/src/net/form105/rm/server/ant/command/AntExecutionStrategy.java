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
package net.form105.rm.server.ant.command;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.model.ExecutionState;
import net.form105.rm.base.model.attribute.AbstractAttribute;
import net.form105.rm.base.model.workflow.Workflow;
import net.form105.rm.base.model.workflow.WorkflowManager;
import net.form105.rm.server.ant.Globals;

/**
 * Checks if ant can be executed. Ant can be executed if the same build isn't running already. We want protect
 * that a build isn't running twice. The same build process can be started if there isn't another running. A build
 * has an id and is configured by its configuration. 
 * @author heikok
 *
 */
public class AntExecutionStrategy implements IExecutionStrategy {

	@Override
	public boolean isExecutable(Object object) {
		
		String groupId = (String) object;
		
		WorkflowManager manager = (WorkflowManager) Agent.getComponentById("workflowManager");

		List<Workflow> workflows = manager.getWorkflowByAttributeValue(Globals.ATTRIBUTE_ID_HOTFOLDER, groupId);

		for (Workflow workflow : workflows) {
			AbstractAttribute<?> attr = workflow.getAttributeById(Globals.ATTRIBUTE_ID_STATUS);
			boolean created = attr.getValueAsString().equals(ExecutionState.NotStarted.toString());
			boolean finished = attr.getValueAsString().equals(ExecutionState.Finished.toString());
			if ((!created) && (!finished)) {
				return false;
			} 
		}
		return true;
	}

}
