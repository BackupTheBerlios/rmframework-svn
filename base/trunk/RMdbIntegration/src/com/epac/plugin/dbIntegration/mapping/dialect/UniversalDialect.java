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
package com.epac.plugin.dbIntegration.mapping.dialect;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.epac.plugin.dbIntegration.mapping.AbstractDBEntity;
import com.epac.plugin.dbIntegration.mapping.DBFieldType;
import com.epac.plugin.dbIntegration.mapping.IDbColumn;
import com.epac.plugin.dbIntegration.mapping.statement.StatementConstant;


public class UniversalDialect implements IDialect, Serializable {

	private static final long serialVersionUID = 1L;

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
		sb.append(StatementConstant.BLANK_STRING);
		return sb.toString();
	}
	
	
	public String getFieldPartWithoutPK() {
		StringBuilder sb = new StringBuilder();
		for (IDbColumn column : entity.getColumns()) {
			if (column.isPrimaryColumn()) continue;
			sb.append("\"");
			sb.append(column.getDbColumnName());
			sb.append("\"");
			sb.append(',');
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(StatementConstant.BLANK_STRING);
		return sb.toString();
	}

	/**
	 * Example: UPDATE OrderLines SET <<<"Part #"='PA28034',
	 * "Quantity"='101.0'>>> WHERE Order Line #=158766
	 * 
	 * @return
	 */
	public String getFieldAssignmentPart() {

		StringBuffer sb = new StringBuffer();

		for (IDbColumn column : entity.getColumns()) {
			
			String fieldValue = getFieldValue(column);
			
			if (fieldValue == null) continue;
			
			if (column.isPrimaryColumn())
				continue;
			sb.append(StatementConstant.BLANK_STRING);
			sb.append('\"');
			sb.append(column.getDbColumnName());
			sb.append('\"');
			sb.append('=');

			String targetField = column.getDeclaredField();
			targetField = Character.toUpperCase(targetField.charAt(0)) + targetField.substring(1);

			Method method;
			try {
				sb.append(fieldValue);
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
			sb.append(getFieldValue(column));
			sb.append(',');
		}
		if (sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	public String getDelemitedFieldValuesWithoutPK() {
		StringBuffer sb = new StringBuffer();
		String sd = "";
		for (IDbColumn column : entity.getColumns()) {
			if (column.isPrimaryColumn()) continue;
			sb.append(getFieldValue(column));
			sb.append(',');
		}
		if (sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public String getIdSelectionPart() {
		StringBuffer sb = new StringBuffer();
		sb.append(StatementConstant.QUOTATION_MARK);
		sb.append(entity.getPrimaryColumn().getDbColumnName());
		sb.append(StatementConstant.QUOTATION_MARK);
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

	/**
	 * Get the value of a declared field by reflection
	 * 
	 * @param entity
	 * @param column
	 * @return
	 */
	public String getFieldValue(IDbColumn column) {
		Object returnValue = "";

		String sd = "";

		try {

			String targetField = column.getDeclaredField();
			targetField = Character.toUpperCase(targetField.charAt(0)) + targetField.substring(1);
			Method method = entity.getClass().getDeclaredMethod("get" + targetField);
			returnValue = method.invoke(entity);
		} catch (Exception ex) {
			logger.error(ex, ex);
		}
		
		if (column.getFieldType() == DBFieldType.VARCHAR && returnValue != null) sd = "\'";

		StringBuffer sb = new StringBuffer();
		sb.append(sd);
		if (returnValue == null) {
			sb.append(StatementConstant.NULL_STRING);
		} else {
			sb.append(column.getConverter().toString(returnValue));
		}
		
		sb.append(sd);
		return sb.toString();
	}

	//TODO: adding constrain object to allow simple 
	@Override
	public String getConstrain() {
		return entity.getConstrain();
	}

}
