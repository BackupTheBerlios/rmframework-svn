/*
 * Copyright (c) 2009, form105 Heiko Kundlacz
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
package net.form105.rm.base.db.dialect;


public interface IDialect {

	/**
	 * Create the field part of the select statement which is created of the columns
	 * of the entity object
	 * @param entity
	 * @return
	 */
	public abstract String getFieldPart();

	public abstract String getTablePart();

	public abstract String getSelectStatement();
	
	public abstract String getDelemitedFieldValues();
	
	/**
	 * Creates to string to execute an update statement on the database.
	 * example:
	 * update OrderLines set quantity = '5', notes='this is a note' where
	 * "Order #" = '142541' AND "Part #" = 'PA28034'
	 * 
	 * @param entity
	 * @return
	 */
	public abstract String getUpdateStatement();
	
	/**
	 * Creates a string to execute an insert statement on the database.
	 * @param entity
	 * @return
	 */
	public abstract String getInsertStatement();

}