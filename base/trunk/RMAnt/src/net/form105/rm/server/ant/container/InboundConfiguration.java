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
package net.form105.rm.server.ant.container;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.validator.IInboundValidator;
import net.form105.rm.server.ant.config.ConfigParameter;
import net.form105.rm.server.ant.config.ConfigParameterMap;
import net.form105.rm.server.ant.hotfolder.IInboundListener;

import org.apache.log4j.Logger;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.picocontainer.Startable;

public class InboundConfiguration implements Startable {
	
	private static Logger logger = Logger.getLogger(InboundConfiguration.class);
	
	private String inboundType;
	
	private Element xmlElement;
	private List<IInboundListener> listenerList = new ArrayList<IInboundListener>();
	private List<IInboundValidator> validatorList  = new ArrayList<IInboundValidator>();
	private ConfigParameterMap paramMap = new ConfigParameterMap();
	
	private AbstractCallbackCommand command;
	
	
	public void readXml(Node xmlNode) {
		
		List<Node> nodes;
		XPath xPath;
		
		inboundType = xmlNode.valueOf("@type");
		
		xPath = DocumentHelper.createXPath("//inbound/parameters/parameter");
		nodes = (List<Node>) xPath.selectNodes(xmlNode);
		
		for (Node node : nodes) {
			logger.info(node);
			paramMap.addParameter(new ConfigParameter(node.valueOf("@key"), node.valueOf("@value")));
		}
		
		xPath = DocumentHelper.createXPath("//inbound/validators/validator");
		nodes = (List<Node>) xPath.selectNodes(xmlNode);
		for (Node node : nodes) {

			IInboundValidator validator = (IInboundValidator) Agent.getComponentById(node.getText());
			validatorList.add(validator);
		}
		
		xPath = DocumentHelper.createXPath("//inbound/listeners/listener");
		nodes = (List<Node>) xPath.selectNodes(xmlNode);
		for (Node node : nodes) {
			IInboundListener inboundListener = (IInboundListener) Agent.getComponentById(node.getText());
			listenerList.add(inboundListener);
		}
		
		xPath = DocumentHelper.createXPath("//inbound/executor");
		logger.info(xPath.selectSingleNode(xmlNode).getText());
		
		command = (AbstractCallbackCommand) Agent.getComponentById(xPath.selectSingleNode(xmlNode).getText());
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
	
	public void setXmlConfiguration(Element xmlElement) {
		this.xmlElement = xmlElement;
	}
	
	public ConfigParameterMap getParameterMap() {
		return paramMap;
	}

	public List<IInboundListener> getConfiguredListeners() {
		return listenerList;
	}
	
	public List<IInboundValidator> getValidators() {
		return validatorList;
	}
	
	public AbstractCallbackCommand getExecutionCommand() {
		return command;
	}
	
	public String getParameter(String key) {
		return paramMap.getParameter(key);
	}

}
