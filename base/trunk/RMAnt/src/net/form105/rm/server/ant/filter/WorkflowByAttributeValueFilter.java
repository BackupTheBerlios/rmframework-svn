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
package net.form105.rm.server.ant.filter;

import net.form105.rm.base.filter.IFilter;
import net.form105.rm.base.model.attribute.AbstractAttribute;
import net.form105.rm.base.model.workflow.Workflow;

/**
 * Checks if a workflow has an attribute with id hotfolder and the value equals to a provided filter value
 * @author heikok
 *
 */
public class WorkflowByAttributeValueFilter implements IFilter<Workflow> {

	private static final long serialVersionUID = -1412483417622046969L;

	private String filterValue;
	private String attributeId;
	
	public WorkflowByAttributeValueFilter(String attributeId, String filterValue) {
		this.filterValue = filterValue;
		this.attributeId = attributeId;
	}
	
	@Override
	public boolean filter(Workflow object) {
		AbstractAttribute<?> attribute = object.getAttributeById(attributeId);
		if (attribute.getValue().equals(filterValue)) return true;
		return false;
	}

}
