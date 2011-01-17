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
package net.form105.rm.base.model.workflow;

/**
 * The possible status of a workflow
 * @author heikok
 *
 */
public enum WorkflowStatus {
	
	CREATED(10),
	RUNNING(20),
	FINISHED(30);
	
	private int statusNum;
	
	private WorkflowStatus(int statusNum) {
		this.statusNum = statusNum;
	}
	
	public int getStatusNum() {
		return this.statusNum;
	}
	
	public String getStatusByInt(int statusNum) {
		WorkflowStatus[] states = this.values();
		for (WorkflowStatus wfStatus : states) {
			if (wfStatus.getStatusNum() == statusNum) {
				return wfStatus.toString();
			}
		}
		
		return "not defined";
	}

}
