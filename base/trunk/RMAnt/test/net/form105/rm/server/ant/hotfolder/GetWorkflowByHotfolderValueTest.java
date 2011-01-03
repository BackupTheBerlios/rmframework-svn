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
package net.form105.rm.server.ant.hotfolder;

import java.util.List;

import junit.framework.Assert;
import net.form105.rm.base.model.attribute.StringAttribute;
import net.form105.rm.base.query.DefaultFilterQuery;
import net.form105.rm.server.ant.Globals;
import net.form105.rm.server.ant.container.WorkflowContainer;
import net.form105.rm.server.ant.filter.WorkflowByAttributeValueFilter;
import net.form105.rm.server.ant.model.Workflow;
import net.form105.rm.server.ant.selection.WorkflowByAttributeSelection;

import org.junit.Before;
import org.junit.Test;


public class GetWorkflowByHotfolderValueTest {
	
	private WorkflowContainer wfContainer;
	private final int PRODUCT_COUNT = 2;
	private final String HOTFOLDER_ATTR = "hotfolder";
	
	@Before
	public void setUp() throws Exception {
		Workflow wf1 = new Workflow("wf1", "workflow1", "hotfolder");
		Workflow wf2 = new Workflow("wf2", "workflow2", "hotfolder");
		StringAttribute attr1 = new StringAttribute(HOTFOLDER_ATTR, "Hotfolder 1", "/Users/heikok/temp/hotfolder/1");
		StringAttribute attr2 = new StringAttribute(HOTFOLDER_ATTR, "Hotfolder 2", "/Users/heikok/temp/hotfolder/2");
		wf1.addAttribute(attr1);
		wf2.addAttribute(attr2);
		
		// add a workflow to the workflow container
		wfContainer = new WorkflowContainer();
		wfContainer.start();
		wfContainer.addWorkflow(wf1);
		wfContainer.addWorkflow(wf2);
		wfContainer.stop();
	}
	
	@Test
	public void testWorkflowAttributeValue() {
		WorkflowByAttributeSelection selection = new WorkflowByAttributeSelection(Globals.ATTRIBUTE_ID_HOTFOLDER, wfContainer);
		WorkflowByAttributeValueFilter filter = new WorkflowByAttributeValueFilter(Globals.ATTRIBUTE_ID_HOTFOLDER,"/Users/heikok/temp/hotfolder/1");
		DefaultFilterQuery<Workflow> query = new DefaultFilterQuery<Workflow>(selection, filter);
		List<Workflow> resultList = query.execute();
		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals("/Users/heikok/temp/hotfolder/1", resultList.get(0).getAttributeById(HOTFOLDER_ATTR).getValue());
	}

}
