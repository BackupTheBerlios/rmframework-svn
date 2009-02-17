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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.form105.rm.base.db.mapping.converter.IResultSetConverter;
import com.form105.rm.base.db.mapping.converter.ResultSetConverterFactory;

public abstract class AbstractDBEntity {
	
	private List<DBColumn> colList;
	
	public List<DBColumn> getColumns() {
		colList = new ArrayList<DBColumn>();
		Field[] fields = this.getClass().getFields();
		for (Field field : fields) {
			MappingColumn mCol = field.getAnnotation(MappingColumn.class);
			if (mCol != null) {
				DBColumn col = new DBColumn(getTable(), mCol.fieldName(), field.getName());
				colList.add(col);
			}
		}
		return colList;
	}
	
	public DBTable getTable() {
		MappingTable mTable = this.getClass().getAnnotation(MappingTable.class);
		DBTable table = new DBTable(mTable.tableName());
		return table;
	}
	
	public boolean isValid() {
		return true;
	}
	
	protected IResultSetConverter<?> getConverter(String fieldType) {
		DBFieldType type = DBFieldType.valueOf(fieldType);
		return ResultSetConverterFactory.getConverter(type);
	}

	public void getQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		for (DBColumn col : colList) {
			sb.append(col.getColumnName());
			sb.append(',');
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(" from ");
		sb.append(getTable().getTableName());
	}
}
