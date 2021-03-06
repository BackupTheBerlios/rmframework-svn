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
package net.form105.rm.base.exception;

import net.form105.rm.base.i18n.I18nMessage;

public class RMIntegrationException extends RMException {

	private static final long serialVersionUID = 1L;
	
	public RMIntegrationException(I18nMessage message, String key, String[] params) {
		super(message, key, params);
	}
	
	public RMIntegrationException(I18nMessage message, String key, String[] params, Throwable cause) {
    	super(message.getMessage(key, params), cause);
    }

}
