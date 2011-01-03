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
package net.form105.rm.server.ant.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.form105.rm.base.selection.AbstractSelection;
import net.form105.rm.server.ant.container.WorkflowContainer;
import net.form105.rm.server.ant.model.Workflow;

public class WorkflowByAttributeSelection extends AbstractSelection<Workflow> {
	
	private static final long serialVersionUID = -6035241290914212008L;
	private String attributeId;
	private WorkflowContainer wfContainer;
	
	public WorkflowByAttributeSelection(String attributeId, WorkflowContainer wfContainer) {
		this.attributeId = attributeId;
		this.wfContainer = wfContainer;
	}

	@Override
	public List<Workflow> select() {
		List<Workflow> wfList = new ArrayList<Workflow>();
		Collection<Workflow> allWorkflows = wfContainer.getWorkflows();
		for (Workflow workflow : allWorkflows) {
			if (workflow.getAttributeById(attributeId) != null) {
				wfList.add(workflow);
			}
		}
		return wfList;
	}

}
