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
import net.form105.rm.base.db.MappingColumn;
import net.form105.rm.base.db.MappingTable;

@MappingTable(tableName="Orders")
public class PaceOrderDbEntity extends AbstractDBEntity {
	
	@MappingColumn(fieldName="Order #", fieldType="VARCHAR")
	private String orderId;
	
	@MappingColumn(fieldName="Customer #",fieldType="VARCHAR")
	private String customerId;
	
	@MappingColumn(fieldName="gQuantity",fieldType="DOUBLE")
	private Double gQuantity;
	
	@MappingColumn(fieldName="Customer Name",fieldType="VARCHAR")
	private String customerName;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Double getGQuantity() {
		return gQuantity;
	}

	public void setGQuantity(Double quantity) {
		gQuantity = quantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
