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
package net.form105.rm.server.query.db;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.model.Order;
import net.form105.rm.base.model.parameter.IntParameter;
import net.form105.rm.base.model.parameter.StringParameter;
import net.form105.rm.base.query.AbstractSimpleQuery;
import net.form105.rm.base.service.IResult;
import net.form105.rm.server.db.entity.PaceOrderDbEntity;

import org.apache.log4j.Logger;


public class PaceOrderQuery extends AbstractSimpleQuery<Order> {
	
	public static Logger logger = Logger.getLogger(PaceOrderQuery.class);

	private static final long serialVersionUID = 1L;

	@Override
	public List<Order> execute() {
		PaceOrderDbEntity entity = new PaceOrderDbEntity();
		IResult<AbstractDBEntity> result = entity.executeSelectAllQuery();
		logger.debug("Entities got: "+result.getResultList().size());
		
		List<Order> orderList = new ArrayList<Order>();

		for (AbstractDBEntity resultEntity : result.getResultList()) {
			PaceOrderDbEntity orderEntity = (PaceOrderDbEntity) resultEntity;
			Order order = new Order();
			order.setElementId(orderEntity.getOrderId());
			order.setName(orderEntity.getOrderId());
			order.setType("paceOrder");
			StringParameter orderIdParameter = new StringParameter("orderId", "Order Id", orderEntity.getOrderId());
			order.addParameter(orderIdParameter);
			
			StringParameter customerIdParameter = new StringParameter("customerId", "Customer Id", orderEntity.getCustomerId());
			order.addParameter(customerIdParameter);
			
			StringParameter customerNameParameter = new StringParameter("customerName", "Customer Name", orderEntity.getCustomerName());
			order.addParameter(customerNameParameter);
			
			IntParameter gQuantity = new IntParameter("gQuantity", "G Quantity", orderEntity.getGQuantity());
			order.addParameter(gQuantity);
			
			orderList.add(order);
		}
		
		return orderList;
	}

}
