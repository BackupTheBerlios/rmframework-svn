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

import junit.framework.Assert;
import net.form105.rm.base.model.attribute.StringAttribute;
import net.form105.rm.base.model.workflow.Task;
import net.form105.rm.base.model.workflow.Workflow;

import org.junit.Before;
import org.junit.Test;

public class WorkflowTest {

	private Workflow workflow;
	
	@Before
	public void setUp() throws Exception {
		workflow = new Workflow("id001", "name001", "type001");
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("name001", workflow.getName());
	}

	@Test
	public void testGetId() {
		Assert.assertEquals("id001", workflow.getElementId());
	}

	@Test
	public void testGetType() {
		Assert.assertEquals("type001", workflow.getType());
	}

	@Test
	public void testAddTask() {
		Task task = new Task(workflow, "taskId001", "taskName001");
		workflow.addTask(task);
		Assert.assertEquals("taskId001", task.getElementId());
	}

	@Test
	public void testRemoveTask() {
		Task task = new Task(workflow, "taskId002", "taskName002");
		workflow.addTask(task);
		Assert.assertNotNull(workflow.getTask("taskId002"));
		workflow.removeTask(task);
		Assert.assertNull(workflow.getTask("taskId002"));
	}

	@Test
	public void testGetCreationTime() {
		Assert.assertNotNull(workflow.getCreationTime());
	}

	@Test
	public void testAddAttribute() {
		workflow.addAttribute(new StringAttribute("attributeId001", "attributeName001", "attributeValue001"));
		Assert.assertNotNull(workflow.getAttributeById("attributeId001"));
	}

}
