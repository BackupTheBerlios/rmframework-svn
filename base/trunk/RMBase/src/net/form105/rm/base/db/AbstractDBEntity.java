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

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.db.dalect.IDialect;
import net.form105.rm.base.db.dalect.UniversalDialect;

import org.apache.log4j.Logger;

public abstract class AbstractDBEntity {
	
	public static Logger logger = Logger.getLogger(AbstractDBEntity.class);
	public List<DBColumn> colList;
	
	public JdbcOutboundHandler outboundHandler;
	public IDialect dialect;
	
	public AbstractDBEntity() {
		logger.info("instantiate Abstract class");
		colList = getColumns();
		outboundHandler = new JdbcOutboundHandler();
		dialect = new UniversalDialect();
	}
	
	public List<DBColumn> getColumns() {
		List<DBColumn> colList = new ArrayList<DBColumn>();
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields) {
			MappingColumn mCol = field.getAnnotation(MappingColumn.class);
			if (mCol != null) {
				DBColumn col = new DBColumn(getTable(), mCol.fieldName(), field.getName(), mCol.fieldType());
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
	
	public List<AbstractDBEntity> executeSelectAllQuery() {
		List<AbstractDBEntity> list = new ArrayList<AbstractDBEntity>();
		try {
			list = outboundHandler.select(this);
		} catch (SQLException e) {
			//TODO: catch SQLException
			e.printStackTrace();
		}
		return list;
	}
	
	public IDialect getDialect() {
		return dialect;
	}
	
	public AbstractDBEntity getNewInstance() {
		AbstractDBEntity entity = null;
		try {
			entity = this.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	
	
	
}
