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

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.DBColumn;

import org.apache.log4j.Logger;

public class UniversalDialect implements IDialect {

	public static Logger logger = Logger.getLogger(UniversalDialect.class);

	private final char BLANK_STRING = ' ';
	private final String FROM_STRING = "FROM";
	private final String SELECT_STRING = "SELECT";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.form105.rm.base.db.dalect.IDialect#getFieldPart(net.form105.rm.base
	 * .db.AbstractDBEntity)
	 */
	public String getFieldPart(AbstractDBEntity entity) {
		StringBuilder sb = new StringBuilder();
		for (DBColumn column : entity.getColumns()) {
			sb.append("\"");
			sb.append(column.getColumnName());
			sb.append("\"");
			sb.append(',');

			
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.form105.rm.base.db.dalect.IDialect#getTablePart(net.form105.rm.base
	 * .db.AbstractDBEntity)
	 */
	public String getTablePart(AbstractDBEntity entity) {
		return entity.getTable().getTableName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.dalect.IDialect#getSelectCommand()
	 */
	public String getSelectCommand() {
		return SELECT_STRING;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.dalect.IDialect#getFromCommand()
	 */
	public String getFromCommand() {
		return FROM_STRING;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.form105.rm.base.db.dalect.IDialect#getBlank()
	 */
	public char getBlank() {
		return BLANK_STRING;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.form105.rm.base.db.dalect.IDialect#concatenateSelectStatement(net
	 * .form105.rm.base.db.AbstractDBEntity)
	 */
	public String concatenateSelectStatement(AbstractDBEntity entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(getSelectCommand());
		sb.append(getBlank());
		sb.append(getFieldPart(entity));
		sb.append(getFromCommand());
		sb.append(getBlank());
		sb.append(getTablePart(entity));
		logger.debug("Select statement is: " + sb.toString());
		return sb.toString();
	}

}
