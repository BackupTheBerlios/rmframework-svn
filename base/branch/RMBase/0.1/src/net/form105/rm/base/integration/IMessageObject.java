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
package net.form105.rm.base.integration;

import java.util.Collection;

/**
 * A message object which is an abstract representation of a message. At construction the ids for the sender
 * and the receiver are identifiers for the source and target of the message path.
 * @author heiko
 * @param <C> The type of content
 */
public interface IMessageObject<C> {
	
	/**
	 * Getting the id of the sender. 
	 * @return
	 */
	public String getSenderId();
	
	/**
	 * Getting the id of the receiver
	 * @return
	 */
	public String getReceiverId();
	
	/**
	 * The content which is delivered from source to target.
	 * @return
	 */
	public Collection<C> getMessageBody();

}
