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
package net.form105.rm.base.db;

import java.sql.ResultSet;

import net.form105.rm.base.db.converter.IResultSetConverter;

public interface IDbColumn {

	/**
	 * Getting the name of the table the column is in
	 * 
	 * @return The database table name
	 */
	public abstract DBTable getDbTableName();

	/**
	 * Getting the converter which converts a {@link ResultSet} to the value
	 * required by the entity object.
	 * 
	 * @return The converter to convert ResultSet fields to entity object fields
	 */
	public abstract IResultSetConverter<?> getConverter();

	/**
	 * Getting the declared field which is the field of the entity object
	 * associated with the database column name
	 * 
	 * @return The field name of the entity object
	 */
	public abstract String getDeclaredField();

	/**
	 * The database column name we working on. This name is used to identify and query the 
	 * column on the database server.
	 * 
	 * @return The name of the column required for select, update, insert
	 */
	public abstract String getDbColumnName();

	/**
	 * The field type of the database column.
	 * 
	 * @return The field type of the column
	 */
	public abstract DBFieldType getFieldType();

	/**
	 * If we update an entry on the database the value of the primary column isn't written.
	 * @return
	 */
	public abstract boolean isPrimaryColumn();

	/**
	 * Get the id generation strategy for the field / db column
	 * 
	 * @return
	 */
	public abstract IdGenerationStrategy getIdGeneration();

}