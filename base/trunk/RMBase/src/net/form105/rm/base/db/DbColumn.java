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

import net.form105.rm.base.db.converter.IResultSetConverter;

/**
 * Represents the definition of a database column. This object is required to
 * associate a database column with an entity object. The declared field is the
 * name of the field of the entity object which is required to set a value via a
 * reflected method.
 * 
 * For creation of a sql select or an update statement the table name and the
 * column name are a prerequisite to access the database.
 * 
 * @author heikok
 * 
 */
public class DbColumn implements IDbColumn {

	private DBTable dbTable;
	private String declaredField;
	IResultSetConverter<?> converter;
	MappingColumn mappingColumnDeclaration;
	IdGeneration idGeneration;

	public DbColumn(DBTable dbTable, String declaredField, MappingColumn mColumn, IResultSetConverter<?> converter,
			IdGeneration idGen) {
		this.dbTable = dbTable;
		this.declaredField = declaredField;
		this.mappingColumnDeclaration = mColumn;
		this.converter = converter;
		this.idGeneration = idGen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.IDBColumn#getDbTableName()
	 */
	public DBTable getDbTableName() {
		return dbTable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.IDBColumn#getConverter()
	 */
	public IResultSetConverter<?> getConverter() {
		return converter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.IDBColumn#getDeclaredField()
	 */
	public String getDeclaredField() {
		return declaredField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.IDBColumn#getDbColumnName()
	 */
	public String getDbColumnName() {
		return mappingColumnDeclaration.fieldName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.IDBColumn#getFieldType()
	 */
	public DBFieldType getFieldType() {
		return DBFieldType.valueOf(mappingColumnDeclaration.fieldType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.IDBColumn#isPrimaryColumn()
	 */
	public boolean isPrimaryColumn() {
		return mappingColumnDeclaration.id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.IDBColumn#getIdGeneration()
	 */
	public IdGenerationStrategy getIdGeneration() {
		return idGeneration.value();
	}
}
