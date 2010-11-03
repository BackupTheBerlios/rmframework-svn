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

import net.form105.rm.base.command.CommandHandler;
import net.form105.rm.base.service.IResult;
import net.form105.rm.server.ant.command.AddWorkflowCommand;
import net.form105.rm.server.ant.model.Workflow;

/**
 * The listener creates a workflow after a file has been arrived. The workflow will have a special state
 * which doesn't allow the execution of the workflow.
 * @author heikok
 *
 */
public class CreateWorkflowHotfolderListener extends AbstractHotfolderListener {

	@Override
	public void fileArrived(HotfolderEvent hotEvent) {
		// create a pre workflow
		// id for the workflow = filePath
		String id = getId(hotEvent);
		String name = hotEvent.getIncomingFilePath();
		String type = "hotfolder";
		AddWorkflowCommand command = new AddWorkflowCommand(id, name, type);
		CommandHandler<Workflow> handler = new CommandHandler<Workflow>();
		handler.execute(command);
		IResult<Workflow> result = handler.getResult();
		// TODO: Result should be sent to handler in case of exceptions
	}

	@Override
	public void fileRemoved(HotfolderEvent hotEvent) {
		// TODO: Should we remove the workflow?
	}

}
