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
package net.form105.rm.base.integration.protocol;

public abstract class AbstractByteReader<T> {
	
	private byte[] input;
	private int pointer;
	
	/**
	 * Construct a byte reader with a pointer to the byte array. The pointer points to the byte of the array
	 * @param input
	 * @param pointer
	 */
	public AbstractByteReader(byte[] input, int pointer) {
		this.input = input;
		this.pointer = pointer;
	}
	
	/**
	 * Get the value of the byte which is the converted byte we want to access
	 * @return
	 */
	public abstract T getValue();
	
	/**
	 * Get the input to read from
	 * @return
	 */
	public byte[] getInput() {
		return input;
	}
	
	/**
	 * Get the pointer from the input.
	 * @return
	 */
	public int getPointer() {
		return pointer;
	}

}
