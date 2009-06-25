/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
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
package net.form105.rm.base.integration.message;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.integration.IMessageTemplate;

public class DefaultMessage<T> {
	
	private long uid;
	private String sender;
	private String acceptor;
	private List<T> body = new ArrayList<T>();
	private IMessageTemplate<T> messageTemplate;
	
	public DefaultMessage() {
		uid = System.currentTimeMillis();
	}
	
	public DefaultMessage(IMessageTemplate messageTemplate) {
		this();
		this.messageTemplate = messageTemplate;
	}
	
	public List<T> getBody() {
		return body;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getAcceptor() {
		return acceptor;
	}

}
