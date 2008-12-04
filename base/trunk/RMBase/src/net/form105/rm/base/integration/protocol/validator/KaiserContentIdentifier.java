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
package net.form105.rm.base.integration.protocol.validator;

import net.form105.rm.base.Container;
import net.form105.rm.base.container.CommunicationConfigurationContainer;
import net.form105.rm.base.integration.IMessageTemplate;

/**
 * Identifies the content by creating a hashcode of the byte header. The byte header should match the registered template
 * hashcode. The header is the raw byte packet of the content.
 * @author heiko
 *
 */
public class KaiserContentIdentifier implements IByteIdentifier {
	
	public int getHashCode(byte[] contentHeader) {
		return 0;
	}
	
	public IMessageTemplate<?> getTemplate(byte[] contentHeader) {
		int hashCode = getHashCode(contentHeader);
		CommunicationConfigurationContainer configContainer = (CommunicationConfigurationContainer) Container.getContainer().getComponent(CommunicationConfigurationContainer.class);
		IMessageTemplate<?> template = configContainer.getTemplate(hashCode);
		return template;
	}
	
	

}
