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
import net.form105.rm.base.model.workflow.WorkflowStatus;
import net.form105.rm.server.ant.Globals;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundObject;

public class AntExecutionStrategy implements IExecutionStrategy {

	@Override
	public boolean isExecutable(Object object) {
		
		HotfolderInboundObject inObject = (HotfolderInboundObject) object;
		
		WorkflowManager manager = (WorkflowManager) Agent.getComponentById("workflowManager");

		List<Workflow> workflows = manager.getWorkflowByAttributeValue(Globals.ATTRIBUTE_ID_HOTFOLDER, inObject.getHotfolderName());

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
