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
import net.form105.rm.base.db.converter.ResultSetConverterFactory;


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
	private String targetField;
	private String fieldType;
	IResultSetConverter<?> converter;

	public DBColumn(DBTable dbTable, String columnName, String fieldName, String fieldType) {
		this.dbTable = dbTable;
		this.columnName = columnName;
		this.targetField = fieldName;
		this.fieldType = fieldType;
		this.converter = ResultSetConverterFactory.getConverter(getFieldType());
		
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
	
	public DBFieldType getFieldType() {
		return DBFieldType.valueOf(fieldType);
	}
}
