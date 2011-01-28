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
package net.form105.rm.server.query;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.model.workflow.Workflow;
import net.form105.rm.base.model.workflow.WorkflowManager;
import net.form105.rm.base.query.IQuery;
import net.form105.rm.base.query.QueryResult;
import net.form105.rm.base.service.IResult;

/**
 * A query to return all workflows of the agent
 * @author heikok
 *
 */
public class GetAllWorkflowsQuery implements IQuery<Workflow> {

	private static final long serialVersionUID = -2909128696320011648L;
	private List<Workflow> result;
	private QueryResult<Workflow> queryResult = new QueryResult<Workflow>();

	@Override
	public List<Workflow> execute() {
		WorkflowManager wfManager = (WorkflowManager) Agent.getComponentById("workflowManager");
		result = new ArrayList<Workflow>(wfManager.getWorkflows());
		return result;
	}

	@Override
	public IResult<Workflow> getQueryResult() {
		return queryResult;
	}

}
