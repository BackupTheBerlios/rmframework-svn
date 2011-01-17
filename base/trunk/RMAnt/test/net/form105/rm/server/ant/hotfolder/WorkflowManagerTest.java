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
import net.form105.rm.base.model.workflow.Workflow;
import net.form105.rm.base.model.workflow.WorkflowManager;
import net.form105.rm.base.model.workflow.WorkflowMap;
import net.form105.rm.server.ant.Globals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


public class WorkflowManagerTest {
	
	private WorkflowManager wfManager;
	private final int PRODUCT_COUNT = 2;
	private final String HOTFOLDER_ATTR = "hotfolder";
	private WorkflowManager workflowManager;
	@Mock private WorkflowMap mockWorkflowMap;
	@Mock private Workflow mockWorkflow;
	@Mock private Workflow wf1;
	@Mock private Workflow wf2;
	@Mock private StringAttribute mockStringAttribute;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		workflowManager = new WorkflowManager(mockWorkflowMap);
	}
	
	@Test 
	public void addAttributeExistTest() {
		// if an attribute exists, update its value (means return value is the attribute)
		when(mockWorkflow.getAttributeById(anyString())).thenReturn(mockStringAttribute);
		when(mockWorkflowMap.getWorkflowById(anyString())).thenReturn(mockWorkflow);
		workflowManager.updateAttribute("myWorkflowId", mockStringAttribute);
		verify(mockStringAttribute).setValue(anyString());
	}
	
	@Test
	public void addAttributeNotExist() {
		// if an attribute doesn't exist, add it (means return value = null)
		when(mockWorkflow.getAttributeById(anyString())).thenReturn(null);
		when(mockWorkflowMap.getWorkflowById(anyString())).thenReturn(mockWorkflow);
		workflowManager.updateAttribute("myWorkflowId", mockStringAttribute);
		verify(mockWorkflow).addAttribute(any(StringAttribute.class));
	}
	
	
	public void testWorkflowAttributeValue() {
		List<Workflow> workflows = workflowManager.getWorkflowByAttributeValue(Globals.ATTRIBUTE_ID_HOTFOLDER, "/Users/heikok/temp/hotfolder/1");
		Assert.assertEquals(1, workflows.size());
		workflows = workflowManager.getWorkflowByAttributeValue(Globals.ATTRIBUTE_ID_HOTFOLDER, "/Users/heikok/temp/hotfolder/2");
		Assert.assertEquals(1, workflows.size());
	}
	
	@Test 
	public void addWorkflowsTest() {
		mockWorkflowMap.addWorkflow(wf1);
		mockWorkflowMap.addWorkflow(wf2);
		verify(mockWorkflowMap).addWorkflow(wf1);
		verify(mockWorkflowMap).addWorkflow(wf2);
	}
	
	@Test
	public void addWorkflowTest() {
		workflowManager.addWorkflow(mockWorkflow);
		verify(mockWorkflowMap).addWorkflow(mockWorkflow);
	}
	
	@Test
	public void removeWorkflowTest() {
		workflowManager.removeWorkflow(mockWorkflow);
		verify(mockWorkflowMap).removeWorkflow(mockWorkflow);
	}
}
