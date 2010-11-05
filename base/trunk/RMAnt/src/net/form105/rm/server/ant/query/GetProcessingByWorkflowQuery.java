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
package net.form105.rm.server.ant.query;

import java.util.List;

import org.apache.tools.ant.taskdefs.AntStructure;

import net.form105.rm.base.Agent;
import net.form105.rm.base.model.attribute.IAttribute;
import net.form105.rm.base.query.AbstractQuery;
import net.form105.rm.server.ant.container.WorkflowContainer;
import net.form105.rm.server.ant.model.ExecutionState;
import net.form105.rm.server.ant.model.Workflow;

/**
 * A query which returns the processing workflow for a specified hotfolder
 * @author heikok
 *
 */
public class GetProcessingByWorkflowQuery extends AbstractQuery<Workflow> {

	private static final long serialVersionUID = 3383859788353208555L;
	
	private String hotfolderPathName;
	
	public GetProcessingByWorkflowQuery(String hotfolderPathName) {
		this.hotfolderPathName = hotfolderPathName;
	}

	
	
	@Override
	public List<Workflow> execute() {
		WorkflowContainer wfContainer = (WorkflowContainer) Agent.getComponentById("workflows");
		for (Workflow workflow : wfContainer.getWorkflows()) {
			IAttribute<?> hotfolderAttr = workflow.getAttributeById("hotfolder");
			IAttribute<?> stateAttr = workflow.getAttributeById("state");
			if (hotfolderAttr.getValue().equals(hotfolderPathName) && stateAttr.getValue().equals(ExecutionState.Running.name())
		}
		return null;
	}

}
