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
package net.form105.rm.base.db.statement;

import net.form105.rm.base.db.dialect.IDialect;

/**
 * Creates a String to update a row in the database
 * @author heikok
 *
 */
public class UpdateStatement extends AbstractStatement {

	@Override
	public StringBuilder getStatement(IDialect dialect) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(StatementConstant.UPDATE_STRING);
		sb.append(StatementConstant.BLANK_STRING);
		// generated
		sb.append(dialect.getTablePart());
		sb.append(StatementConstant.BLANK_STRING);
		sb.append(StatementConstant.SET_STRING);
		sb.append(StatementConstant.BLANK_STRING);
		// generated
		sb.append(dialect.getFieldAssignmentPart());
		sb.append(StatementConstant.BLANK_STRING);
		sb.append(StatementConstant.WHERE_STRING);
		sb.append(StatementConstant.BLANK_STRING);
		// generated
		sb.append(dialect.getIdSelectionPart());
		logStatement(sb);
		return sb;
	}

}