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

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.command.CommandHandler;
import net.form105.rm.base.command.ICommand;
import net.form105.rm.base.model.attribute.StringAttribute;
import net.form105.rm.base.model.workflow.Workflow;
import net.form105.rm.base.model.workflow.WorkflowStatus;
import net.form105.rm.base.service.IResult;
import net.form105.rm.server.ant.Globals;
import net.form105.rm.server.ant.command.AddAttributeCommand;
import net.form105.rm.server.ant.command.AddWorkflowCommand;

/**
 * The listener creates a workflow after a file has been arrived. The workflow will have a special state
 * which doesn't allow the execution of the workflow.
 * @author heikok
 *
 */
public class CreateWorkflowHotfolderListener extends AbstractHotfolderListener {

	@Override
	public void objectArrived(IInboundObject inboundObject) {
		
		HotfolderInboundObject hfObject = (HotfolderInboundObject) inboundObject;
		
		String id = inboundObject.getId();
		String name = "Hotfolder Workflow";
		String type = "hotfolder";
		
		AddWorkflowCommand addWorkflowCommand = new AddWorkflowCommand(id, name, type);
		StringAttribute hotfolderAttribute = new StringAttribute(Globals.ATTRIBUTE_ID_HOTFOLDER, "Path to the Hotfolder", hfObject.getHotfolderName());
		StringAttribute incomingFileAttribute = new StringAttribute(Globals.ATTRIBUTE_ID_INBOUND_FILE, "Path to the incoming file", hfObject.getBuildFileName());
		StringAttribute statusAttribute = new StringAttribute(Globals.ATTRIBUTE_ID_STATUS, Globals.ATTRIBUTE_NAME_STATUS, WorkflowStatus.CREATED.toString());
		
		
		
		CommandHandler<Workflow> handler = new CommandHandler<Workflow>();
		List<ICommand> commandList = new ArrayList<ICommand>();
		commandList.add(addWorkflowCommand);
		commandList.add(new AddAttributeCommand(id, hotfolderAttribute));
		commandList.add(new AddAttributeCommand(id, incomingFileAttribute));
		commandList.add(new AddAttributeCommand(id, statusAttribute));
		handler.execute(commandList);
		IResult<Workflow> result = handler.getResult();
		// TODO: Result should be sent to handler in case of exceptions
	}

	@Override
	public void objectRemoved(IInboundObject hotEvent) {
		// nothing to do
	}
}
