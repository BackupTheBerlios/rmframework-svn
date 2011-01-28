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
package net.form105.rm.base.observer;


import net.form105.rm.base.model.workflow.Workflow;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class WorkflowObserverTest {
	
	private WorkflowObservable wfObservable;
	@Mock
	private RMIWorkflowObserver mockWfObserver;
	@Mock
	private Workflow mockWorkflow;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		this.wfObservable = new WorkflowObservable(new IWorkflowObserver[] {mockWfObserver});
		wfObservable.start();
	}
	
	/**
	 * tests if notification has been occured
	 */
	@Test
	public void addWorkflowNotificationTest() {
		wfObservable.notifyAdd(mockWorkflow);
		verify(mockWfObserver).added(mockWorkflow);
	}
	
	/**
	 * tests if notification has been occured
	 */
	@Test
	public void removeWorkflowNotificationTest() {
		wfObservable.notifyRemove(mockWorkflow);
		verify(mockWfObserver).removed(mockWorkflow);
	}
	
	/**
	 * tests if notification has been occured
	 */
	@Test
	public void updateWorkflowNotificationTest() {
		wfObservable.notifyUpdate(mockWorkflow);
		verify(mockWfObserver).updated(mockWorkflow);
	}

}
