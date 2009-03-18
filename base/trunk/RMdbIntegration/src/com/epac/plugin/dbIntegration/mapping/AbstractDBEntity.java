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
package com.epac.plugin.dbIntegration.mapping;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epac.plugin.dbIntegration.mapping.converter.IResultSetConverter;
import com.epac.plugin.dbIntegration.mapping.converter.ResultSetConverterFactory;
import com.epac.plugin.dbIntegration.mapping.dialect.IDialect;
import com.epac.plugin.dbIntegration.mapping.dialect.UniversalDialect;
import com.epac.plugin.dbIntegration.validator.IEntityValidator;
import com.epac.plugin.dbIntegration.validator.TableAnnotationValidator;

public abstract class AbstractDBEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AbstractDBEntity.class);
	private List<DbColumn> colList;

	private IDialect dialect;
	private IDbColumn primaryColumn;
	
	private String constrain;

	public AbstractDBEntity() {
		isValid();
		colList = createColumnMapping();
		//outboundHandler = new JdbcOutboundHandler();
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
			AIdGeneration idGeneration = field.getAnnotation(AIdGeneration.class);

			AMappingColumn mCol = field.getAnnotation(AMappingColumn.class);
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

	/**
	 * Get the table definition of the entity
	 * @return
	 */
	public DBTable getTable() {
		AMappingTable mTable = this.getClass().getAnnotation(AMappingTable.class);
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

	public IDialect getDialect() {
		return dialect;
	}
	
	protected void setDialect(IDialect dialect) {
		this.dialect = dialect;
	}

	/**
	 * New instances are required for select statements. After executing a
	 * select statements the result should be packaged to an object. This is
	 * often called as the prototype pattern.
	 * 
	 * @return
	 * @see Cloneable
	 */
	public AbstractDBEntity getNewInstance() {
		// AbstractDBEntity entity = null;
		// try {
		// entity = this.getClass().newInstance();
		// } catch (InstantiationException e) {
		// e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// e.printStackTrace();
		// }
		AbstractDBEntity newEntity = (AbstractDBEntity) clone();
		newEntity.setDialect(new UniversalDialect(newEntity));
		return newEntity;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {

		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			logger.error(e, e);
		}
		return object;
	}

	/**
	 * Get the primary column which is defined by the annotation
	 * {@link AMappingColumn}
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
	
	public void setConstraint(String constrain) {
		this.constrain = constrain;
	}
	
	public String getConstrain() {
		if (constrain == null) {
			return "";
		}
		return constrain;
	}

}
