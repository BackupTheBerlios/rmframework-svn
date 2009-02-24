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
package net.form105.rm.base.db.dialect;

import java.lang.reflect.Method;

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.DBFieldType;
import net.form105.rm.base.db.IDbColumn;
import net.form105.rm.base.db.statement.StatementConstant;

import org.apache.log4j.Logger;

public class UniversalDialect implements IDialect {

	public static Logger logger = Logger.getLogger(UniversalDialect.class);
	
	private AbstractDBEntity entity;
	
	public UniversalDialect(AbstractDBEntity entity) {
		this.entity = entity;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.form105.rm.base.db.dalect.IDialect#getFieldPart(net.form105.rm.base
	 * .db.AbstractDBEntity)
	 */
	public String getFieldPart() {
		StringBuilder sb = new StringBuilder();
		for (IDbColumn column : entity.getColumns()) {
			sb.append("\"");
			sb.append(column.getDbColumnName());
			sb.append("\"");
			sb.append(',');
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public String getFieldPartForUpdate() {

		StringBuffer sb = new StringBuffer();

		for (IDbColumn column : entity.getColumns()) {
			if (column.isPrimaryColumn()) continue;
			sb.append(StatementConstant.BLANK_STRING);
			sb.append('\"');
			sb.append(column.getDbColumnName());
			sb.append('\"');
			sb.append('=');

			String targetField = column.getDeclaredField();
			targetField = Character.toUpperCase(targetField.charAt(0)) + targetField.substring(1);

			Method method;
			try {
				sb.append('\'');
				method = entity.getClass().getDeclaredMethod("get" + targetField);
				Object returnValue = method.invoke(entity);
				String value = column.getConverter().toString(returnValue);
				sb.append(value);
				sb.append('\'');
				sb.append(',');
			} catch (Exception e) {
				logger.error(e, e);
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	public String getDelemitedFieldValues() {
		StringBuffer sb = new StringBuffer();
		String sd = "";
		for (IDbColumn column : entity.getColumns()) {
			if (column.getFieldType() == DBFieldType.VARCHAR) sd = "\'";
			sb.append(sd);
			sb.append(getFieldValue(column));
			sb.append(sd);
			sb.append(',');
		}
		if (sb.length() > 0 ) sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public String getIdSelectionPart() {
		StringBuffer sb = new StringBuffer();
		sb.append(entity.getPrimaryColumn().getDbColumnName());
		sb.append('=');
		sb.append(getFieldValue(entity.getPrimaryColumn()));
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.form105.rm.base.db.dalect.IDialect#getTablePart(net.form105.rm.base
	 * .db.AbstractDBEntity)
	 */
	public String getTablePart() {
		return entity.getTable().getTableName();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.form105.rm.base.db.dalect.IDialect#concatenateSelectStatement(net
	 * .form105.rm.base.db.AbstractDBEntity)
	 */
	public String getSelectStatement() {
		StringBuilder sb = new StringBuilder();
		sb.append(StatementConstant.FROM_STRING);
		sb.append(StatementConstant.BLANK_STRING);
		sb.append(getFieldPart());
		sb.append(StatementConstant.FROM_STRING);
		sb.append(StatementConstant.BLANK_STRING);
		sb.append(getTablePart());
		logger.debug("Select statement is: " + sb.toString());
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see net.form105.rm.base.db.dialect.IDialect#getUpdateStatement(net.form105.rm.base.db.AbstractDBEntity)
	 */
	public String getUpdateStatement() {
		StringBuilder sb = new StringBuilder();
		sb.append(StatementConstant.UPDATE_STRING);
		sb.append(StatementConstant.BLANK_STRING);
		// generated
		sb.append(getTablePart());
		sb.append(StatementConstant.BLANK_STRING);
		sb.append(StatementConstant.SET_STRING);
		sb.append(StatementConstant.BLANK_STRING);
		// generated
		sb.append(getFieldPartForUpdate());
		sb.append(StatementConstant.BLANK_STRING);
		sb.append(StatementConstant.WHERE_STRING);
		sb.append(StatementConstant.BLANK_STRING);
		// generated
		sb.append(getIdSelectionPart());
		return sb.toString();
	}

	/** 
	 * Get the value of a declared field by reflection
	 * @param entity
	 * @param column
	 * @return
	 */
	public String getFieldValue(IDbColumn column) {
		Object returnValue = "";
		try {
			String targetField = column.getDeclaredField();
			targetField = Character.toUpperCase(targetField.charAt(0)) + targetField.substring(1);
			Method method = entity.getClass().getDeclaredMethod("get" + targetField);
			returnValue = method.invoke(entity);
		} catch (Exception ex) {
			logger.error(ex, ex);
		}
		String value = column.getConverter().toString(returnValue);
		return value;
	}

	@Override
	public String getInsertStatement() {
		
		return null;
	}

}
