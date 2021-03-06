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
package com.epac.plugin.dbIntegration.mapping.statement;

import com.epac.plugin.dbIntegration.mapping.dialect.IDialect;


public class DeleteStatement extends AbstractStatement {

	@Override
	public StringBuilder getStatement(IDialect dialect) {
		StringBuilder sb = new StringBuilder();
		sb.append(StatementConstant.DELETE_STRING).append(StatementConstant.BLANK_STRING);
		sb.append(dialect.getTablePart()).append(StatementConstant.BLANK_STRING);
		sb.append(StatementConstant.WHERE_STRING).append(StatementConstant.BLANK_STRING);
		sb.append(dialect.getIdSelectionPart());
		logStatement(sb);
		return sb;
	}

}
