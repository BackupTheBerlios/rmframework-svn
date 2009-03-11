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
	
	/**
	 * Same as getFieldPart() but without PK entry
	 * @return
	 */
	public abstract String getFieldPartWithoutPK();

	/**
	 * Create the table part of a sql statement. The table part consists of the table name
	 * @return
	 */
	public abstract String getTablePart();
	
	/**
	 * Field values are the assignments of column names to its values.
	 * @return
	 */
	public abstract String getDelemitedFieldValues();
	
	
	/**
	 * Get the values of the fields from the entity class but left the field if
	 * it is a primary key
	 * @return
	 */
	public abstract String getDelemitedFieldValuesWithoutPK();
	
	/**
	 * Get the selection part for the where condition
	 * example: 
	 * @return
	 */
	public abstract String getIdSelectionPart();
	
	/**
	 * Get the assignment part of a sql statement
	 * example: "Part #"='PA28034', "Quantity"='101.0'
	 * @return
	 */
	public abstract String getFieldAssignmentPart();
	
	/**
	 * Returns a String which declares the where clause from
	 * a select statement
	 * example:
	 * WHERE "Part #"='PA28034'
	 * @return
	 */
	public abstract String getConstrain();
	
	

}