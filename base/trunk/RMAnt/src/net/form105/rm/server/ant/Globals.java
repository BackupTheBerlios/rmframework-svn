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
package net.form105.rm.server.ant;

public class Globals {

	public static final String ATTRIBUTE_ID_HOTFOLDER = "hotfolder";
	public static final String ATTRIBUTE_ID_INBOUND_FILE = "inboundFile";
	
	// Container ids
	public static final String CONTAINER_ID_LOGGER = "logger"; // class='net.form105.rm.base.container.LoggerContainer' />
	public static final String CONTAINER_ID_THREAD = "bgThread"; //class='net.form105.rm.base.container.BackgroundThreadContainer' />
	public static final String CONTAINER_ID_PROPERTIES = "properties"; //class='net.form105.rm.base.container.PropertiesContainer'/>
	public static final String CONTAINER_ID_RMI_SERVER = "rmiServer"; //class='net.form105.rm.base.container.RMIServerContainer'/>
	public static final String CONTAINER_ID_SERVICE_HANDLER = "serviceHandler "; // class='net.form105.rm.base.container.RMIServiceHandlerContainer'/>
	public static final String CONTAINER_ID_QUERYHANDLER = "queryHandler"; // class='net.form105.rm.base.container.RMIQueryHandlerContainer'/>
	public static final String CONTAINER_ID_ANT = "ant"; // class='net.form105.rm.server.ant.container.AntContainer'/>
	public static final String CONTAINER_ID_HOTFOLDERS = "hotfolders"; //class='net.form105.rm.server.ant.container.HotfolderContainer' ></component-implementation>
	public static final String CONTAINER_ID_HOTFOLDER_CONFIG = "hotfolderConfig"; //class='net.form105.rm.server.ant.container.HotfolderConfigContainer' ></component-implementation>
    
	public static final String CONTAINER_ID_WORKFLOWS = "workflows"; // class="net.form105.rm.server.ant.container.WorkflowContainer"></component-implementation>
	public static final String CONTAINER_ID_TASKS = "taskMap"; // class="net.form105.rm.server.ant.container.TaskMapContainer"></component-implementation>
        
	public static final String CONTAINER_ID_COMMANDHANDLER = "commandHandler"; // class="net.form105.rm.server.ant.command.AntCommandHandler"></component-implementation>
    public static final String CONTAINER_ID_FILEVALIDATOR = "fileValidator"; // class='net.form105.rm.server.ant.validator.RealFileValidator'/>
    public static final String CONTAINER_ID_BUILDFILEVALIDATOR = "buildFileValidator"; // class='net.form105.rm.server.ant.validator.BuildFileValidator'/>
	
}
