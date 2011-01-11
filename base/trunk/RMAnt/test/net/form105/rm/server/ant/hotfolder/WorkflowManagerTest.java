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
import net.form105.rm.server.ant.Globals;
import net.form105.rm.server.ant.model.Workflow;
import net.form105.rm.server.ant.workflow.WorkflowManager;
import net.form105.rm.server.ant.workflow.WorkflowMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


public class WorkflowManagerTest {
	
	private WorkflowManager wfManager;
	private final int PRODUCT_COUNT = 2;
	private final String HOTFOLDER_ATTR = "hotfolder";
	@Mock private WorkflowManager mockWorkflows;
	@Mock private WorkflowMap mockWorkflowMap;
	@Mock private Workflow wf1;
	@Mock private Workflow wf2;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);


		
		//wfManager.addWorkflow(wf1);
		//wfManager.addWorkflow(wf2);
		
	}
	
	@Test 
	public void addAttributesTest() {
		StringAttribute attr1 = new StringAttribute(Globals.ATTRIBUTE_ID_HOTFOLDER, "Hotfolder 1", "/Users/heikok/temp/hotfolder/1");
		StringAttribute attr2 = new StringAttribute(Globals.ATTRIBUTE_ID_HOTFOLDER, "Hotfolder 2", "/Users/heikok/temp/hotfolder/2");
		
		when(mockWorkflowMap.getWorkflowById())
		
		wf1.addAttribute(attr1);
		wf2.addAttribute(attr2);
		
		verify(wf1).addAttribute(attr1);
		verify(wf2).addAttribute(attr2);
		
		System.out.println("attribute: "+wf1.getAttributeById(Globals.ATTRIBUTE_ID_HOTFOLDER));
		//verify(mockWorkflowMap).getAllWorkflows();
	}
	
	
	public void testWorkflowAttributeValue() {
		List<Workflow> workflows = mockWorkflows.getWorkflowByAttributeValue(Globals.ATTRIBUTE_ID_HOTFOLDER, "/Users/heikok/temp/hotfolder/1");
		Assert.assertEquals(1, workflows.size());
		workflows = mockWorkflows.getWorkflowByAttributeValue(Globals.ATTRIBUTE_ID_HOTFOLDER, "/Users/heikok/temp/hotfolder/2");
		Assert.assertEquals(1, workflows.size());
	}
	
	@Test 
	public void addWorkflowsTest() {
		mockWorkflowMap.addWorkflow(wf1);
		mockWorkflowMap.addWorkflow(wf2);
		verify(mockWorkflowMap).addWorkflow(wf1);
		verify(mockWorkflowMap).addWorkflow(wf2);
	}

}
