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
package net.form105.rm.server.db.entity;

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.DBFieldType;
import net.form105.rm.base.db.IdGeneration;
import net.form105.rm.base.db.IdGenerationStrategy;
import net.form105.rm.base.db.MappingColumn;
import net.form105.rm.base.db.MappingTable;

@MappingTable(tableName="OrderLines")
public class PaceOrderLineDbEntity extends AbstractDBEntity {
	
	@IdGeneration(IdGenerationStrategy.DBGENERATED)
	@MappingColumn(fieldName="Order Line #", fieldType=DBFieldType.VARCHAR)
	private String orderLineId;
	
	@MappingColumn(fieldName="Part #", fieldType=DBFieldType.VARCHAR)
	private String partId;
	
	@MappingColumn(fieldName="Quantity", fieldType=DBFieldType.INTEGER)
	private Integer quantity;

	/**
	 * @return the orderLineId
	 */
	public String getOrderLineId() {
		return orderLineId;
	}

	/**
	 * @param orderLineId the orderLineId to set
	 */
	public void setOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}

	/**
	 * @return the partId
	 */
	public String getPartId() {
		return partId;
	}

	/**
	 * @param partId the partId to set
	 */
	public void setPartId(String partId) {
		this.partId = partId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
