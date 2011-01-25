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
package net.form105.rm.base.observer;

import net.form105.rm.base.model.workflow.Workflow;

public class WorkflowObserver implements IWorkflowObserver {


	
	/* (non-Javadoc)
	 * @see net.form105.rm.base.observer.WorkflowObservable#addWorkflow(net.form105.rm.base.model.workflow.Workflow)
	 */
	public void added(Workflow workflow) {
		// delegate to RmiCallback
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.base.observer.WorkflowObservable#removeWorkflow(net.form105.rm.base.model.workflow.Workflow)
	 */
	public void removed(Workflow workflow) {
		
	}

	/* (non-Javadoc)
	 * @see net.form105.rm.base.observer.WorkflowObservable#updateWorkflow(net.form105.rm.base.model.workflow.Workflow)
	 */
	public void updated(Workflow workflow) {
		
		
	}
}
