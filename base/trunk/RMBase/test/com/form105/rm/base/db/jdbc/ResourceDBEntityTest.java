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

import java.math.BigDecimal;

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.DBFieldType;
import net.form105.rm.base.db.IdGeneration;
import net.form105.rm.base.db.IdGenerationStrategy;
import net.form105.rm.base.db.MappingColumn;
import net.form105.rm.base.db.MappingTable;

@MappingTable(tableName="resourceElement")
public class ResourceDBEntityTest extends AbstractDBEntity {
	
	@IdGeneration(IdGenerationStrategy.DBGENERATED)
	@MappingColumn(fieldName="resource #", fieldType=DBFieldType.VARCHAR)
	private String objectId;
	
	@MappingColumn(fieldName="dbElementId",fieldType=DBFieldType.VARCHAR)
	private String elementId;
	
	@MappingColumn(fieldName="dbElementType",fieldType=DBFieldType.VARCHAR)
	private String elementType;
	
	@MappingColumn(fieldName="dbElementInteger",fieldType=DBFieldType.INTEGER)
	private Integer elementInteger;
	
	@MappingColumn(fieldName="dbElementFloat",fieldType=DBFieldType.FLOAT)
	private BigDecimal elementFloat;

	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	/**
	 * @return the elementId
	 */
	public String getElementId() {
		return elementId;
	}

	/**
	 * @param elementId the elementId to set
	 */
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	/**
	 * @return the elementType
	 */
	public String getElementType() {
		return elementType;
	}

	/**
	 * @param elementType the elementType to set
	 */
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	/**
	 * @return the elementInteger
	 */
	public Integer getElementInteger() {
		return elementInteger;
	}

	/**
	 * @param elementInteger the elementInteger to set
	 */
	public void setElementInteger(Integer elementInteger) {
		this.elementInteger = elementInteger;
	}

	/**
	 * @return the elementFloat
	 */
	public BigDecimal getElementFloat() {
		return elementFloat;
	}

	/**
	 * @param elementFloat the elementFloat to set
	 */
	public void setElementFloat(BigDecimal elementFloat) {
		this.elementFloat = elementFloat;
	}


	
	

}
