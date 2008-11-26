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

import net.form105.rm.base.exception.RMException;

public interface IProtocolValidator {
	
	/**
	 * Validates the header and returns true if the byte stream can be accepted by the server
	 * @param header
	 * @return
	 */
	public boolean isValid(byte[] header);
	
	/**
	 * Get the length of the header we expect
	 * @return
	 */
	public int getHeaderLength();
	
	public int getPacketId();

}
