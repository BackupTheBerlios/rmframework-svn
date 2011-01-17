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

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Hashtable;

import net.form105.rm.base.model.ExecutionState;
import net.form105.rm.base.model.workflow.Task;
import net.form105.rm.base.model.workflow.Workflow;
import net.form105.rm.base.model.workflow.WorkflowManager;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundObject;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class WorkflowListenerTest {

	@Mock
	private WorkflowManager mockWfManager;
	@Mock
	private Workflow mockWorkflow;
	@Mock
	private HotfolderInboundObject mockInboundObject;
	@Mock
	private BuildEvent mockBuildEvent;
	@Mock
	private Target mockTarget;
	@Mock
	private Hashtable mockTargetTable;
	@Mock
	private Project mockProject;
	@Mock 
	private Task mockTask;
	private AntBuildListener wfListener;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		wfListener = new AntBuildListener(mockWfManager, mockInboundObject);
	}

	@Test
	public void buildStartedTest() {
		Hashtable hashTable = new Hashtable();
		hashTable.put("1", mockTarget);
		hashTable.put("2", mockTarget);
		when(mockBuildEvent.getProject()).thenReturn(mockProject);

		when(mockWfManager.getWorkflowById(anyString())).thenReturn(mockWorkflow);
		// when(mockTarget.getName()).thenReturn(anyString());
		// when(mockTarget.getDescription()).thenReturn(anyString());
		when(mockTargetTable.get(anyObject())).thenReturn(mockTarget);
		when(mockProject.getTargets()).thenReturn(hashTable);

		wfListener.buildStarted(mockBuildEvent);
		verify(mockWfManager, times(2)).addTask(any(Workflow.class), any(Task.class));
		verify(mockTarget, times(2)).getName();
		verify(mockTarget, times(2)).getDescription();
	}
	
	@Test
	public void buildFinishedTest() {
		when(mockWfManager.getWorkflowById(anyString())).thenReturn(mockWorkflow);
		wfListener.buildFinished(mockBuildEvent);
		verify(mockWorkflow).updateState(any(ExecutionState.class));
	}
	
	public void targetFinishedTest() {
		
	}
	
	@Test
	public void targetStarted() {
		when(mockWfManager.getWorkflowById(anyString())).thenReturn(mockWorkflow);
		when(mockBuildEvent.getTarget()).thenReturn(mockTarget);
		when(mockWfManager.getTaskById(anyString(), anyString())).thenReturn(mockTask);
		wfListener.targetStarted(mockBuildEvent);
		verify(mockTask).updateState(any(ExecutionState.class));
		verify(mockTask).setStartTime();
	}
	
	@Test
	public void targetFinished() {
		when(mockWfManager.getWorkflowById(anyString())).thenReturn(mockWorkflow);
		when(mockBuildEvent.getTarget()).thenReturn(mockTarget);
		when(mockWfManager.getTaskById(anyString(), anyString())).thenReturn(mockTask);
		wfListener.targetFinished(mockBuildEvent);
		verify(mockTask).updateState(any(ExecutionState.class));
		verify(mockTask).setFinishTime();
	}

}
