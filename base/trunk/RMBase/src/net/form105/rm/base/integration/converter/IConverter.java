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
package net.form105.rm.base.integration.converter;

/**
 * Converts an input object to an output object. Input and output are defined from the view
 * of the converter. The converter itself is the reference point for the input. So use this
 * converter for inbound and outbound.
 * @author heiko
 *
 * @param <I>
 * @param <O>
 */
public interface IConverter<I, O> {
	
	/**
	 * Converts the inputObject to the output object
	 * @param inboundObject The object send into the converter
	 * @return
	 */
	public O convert(I inboundObject);


}
