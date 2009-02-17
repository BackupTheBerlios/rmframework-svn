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
package com.form105.rm.base.db.mapping;

import java.sql.ResultSet;

import com.form105.rm.base.db.mapping.converter.IResultSetConverter;

/**
 * Represents a column of a database. It consists of a name and a table where it is
 * placed in. The converter is responsible for converting a {@link ResultSet} to the type
 * that is required by the entity.
 * @author heikok
 *
 */
public class DBColumn {
	
	private String columnName;
	private DBTable dbTable;
	private IResultSetConverter<?> converter;
	private String targetField;

	public DBColumn(DBTable dbTable, String columnName, String fieldName) {
		this.dbTable = dbTable;
		this.columnName = columnName;
		this.targetField = fieldName;
	}
	
	public DBTable getDbTable() {
		return dbTable;
	}

	public void setDbTable(DBTable dbTable) {
		this.dbTable = dbTable;
	}

	public IResultSetConverter<?> getConverter() {
		return converter;
	}

	public void setConverter(IResultSetConverter<?> converter) {
		this.converter = converter;
	}

	public String getTargetField() {
		return targetField;
	}

	public void setTargetField(String fieldName) {
		this.targetField = fieldName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}
