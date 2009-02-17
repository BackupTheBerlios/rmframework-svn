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
package com.form105.rm.base.db.jdbc;

import com.form105.rm.base.db.mapping.AbstractDBEntity;
import com.form105.rm.base.db.mapping.MappingColumn;
import com.form105.rm.base.db.mapping.MappingTable;

@MappingTable(tableName="resourceElement")
public class ResourceDbMapper extends AbstractDBEntity {
	
	@MappingColumn(fieldName="elementId", fieldType="VARCHAR")
	private String elementId;
	
	@MappingColumn(fieldName="elementName", fieldType="VARCHAR")
	private String elementName;
	
	@MappingColumn(fieldName="elementType", fieldType="VARCHAR")
	private String elementType;
	
	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	
	
}
