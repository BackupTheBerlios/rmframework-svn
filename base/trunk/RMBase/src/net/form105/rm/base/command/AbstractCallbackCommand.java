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
package net.form105.rm.base.command;

public abstract class AbstractCallbackCommand extends AbstractCommand {
	
	private ICommandListener commandListener;
	
	public AbstractCallbackCommand() {
		this(new ICommandListener() {
			@Override
			public void finished(CommandEvent event) {}

			@Override
			public void started(CommandEvent event) {}
		});
	}
	
	public AbstractCallbackCommand(ICommandListener commandListener) {
		this.commandListener = commandListener;
	}
	
	public ICommandListener getCommandListener() {
		return commandListener;
	}
	
	public void setCommandListener(ICommandListener commandListener) {
		this.commandListener = commandListener;
	}
}
