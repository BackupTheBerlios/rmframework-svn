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
package net.form105.rm.base.model.attribute;

/**
 * Immutable String attribute which can be attached to a workflow
 * @author heikok
 *
 */
public class StringAttribute extends AbstractAttribute<String> {
	
	private static final long serialVersionUID = 3589606365224801720L;

	public StringAttribute(String id, String name, String value) {
		super(id, name, value);
	}

	@Override
	public String getValueAsString() {
		return getValue();
	}



}
