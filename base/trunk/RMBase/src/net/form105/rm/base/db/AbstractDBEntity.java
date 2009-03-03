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
package net.form105.rm.base.db;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.db.converter.IResultSetConverter;
import net.form105.rm.base.db.converter.ResultSetConverterFactory;
import net.form105.rm.base.db.dialect.IDialect;
import net.form105.rm.base.db.dialect.UniversalDialect;
import net.form105.rm.server.db.validator.IEntityValidator;
import net.form105.rm.server.db.validator.TableAnnotationValidator;

import org.apache.log4j.Logger;

public abstract class AbstractDBEntity {

	public static Logger logger = Logger.getLogger(AbstractDBEntity.class);
	public List<DbColumn> colList;

	public JdbcOutboundHandler outboundHandler;
	public IDialect dialect;
	public IDbColumn primaryColumn;

	public AbstractDBEntity() {
		isValid();
		colList = createColumnMapping();
		outboundHandler = new JdbcOutboundHandler();
		dialect = new UniversalDialect(this);
	}

	/**
	 * Create the columns which associates database columns with the fields of
	 * the entity class
	 * 
	 * @return
	 */
	protected List<DbColumn> createColumnMapping() {
		List<DbColumn> colList = new ArrayList<DbColumn>();
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields) {
			IdGeneration idGeneration = field.getAnnotation(IdGeneration.class);

			MappingColumn mCol = field.getAnnotation(MappingColumn.class);
			if (mCol != null) {
				IResultSetConverter<?> converter = ResultSetConverterFactory.getConverter(mCol.fieldType());
				DbColumn col = new DbColumn(getTable(), field.getName(), mCol, converter, idGeneration);
				if (idGeneration != null) {
					primaryColumn = col;
				}
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

	/**
	 * Check for validation of the entity object and class. This method executes
	 * registered validators.
	 * 
	 * @return
	 * @see IEntityValidator
	 */
	public boolean isValid() {
		TableAnnotationValidator tableAnnotationValidator = new TableAnnotationValidator();
		if (!tableAnnotationValidator.isValid(this)) {
			return false;
		}
		return true;
	}

	public List<AbstractDBEntity> executeSelectAllQuery() {
		List<AbstractDBEntity> list = new ArrayList<AbstractDBEntity>();
		try {
			list = outboundHandler.select(this);
		} catch (SQLException e) {
			// TODO: catch SQLException
			e.printStackTrace();
		}
		return list;
	}

	public IDialect getDialect() {
		return dialect;
	}

	/**
	 * New instances are required for select statements. After executing a
	 * select statements the result should be packaged to an object.
	 * This is often called as the prototype pattern. 
	 * 
	 * @return
	 * @see Cloneable
	 */
	public AbstractDBEntity getNewInstance() {
//		AbstractDBEntity entity = null;
//		try {
//			entity = this.getClass().newInstance();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
		AbstractDBEntity newEntity = (AbstractDBEntity) clone();
		return newEntity;
	}
	
	public Object clone() {
		
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			logger.error(e,e);
		}
		return object;
	}

	/**
	 * Get the primary column which is defined by the annotation
	 * {@link MappingColumn}
	 * 
	 * @return
	 */
	public IDbColumn getPrimaryColumn() {
		return primaryColumn;
	}

	/**
	 * Get all columns which are defined by the annotation @
	 * 
	 * @return
	 */
	public List<DbColumn> getColumns() {
		return colList;
	}

}
