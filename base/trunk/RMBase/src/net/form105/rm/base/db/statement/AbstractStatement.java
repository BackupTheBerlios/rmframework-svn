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

import net.form105.rm.base.Agent;
import net.form105.rm.base.db.dialect.IDialect;

import org.apache.log4j.Logger;

public abstract class AbstractStatement implements IStatement {

	@Override
	public abstract String getStatement(IDialect dialect);
	
	public void log(String logString) {
		Logger logger = Logger.getLogger(this.getClass());
		String logProp = Agent.getRMProperty("log.jdbcIntegration");
		if (logProp != null && logProp.equals("on")) {
			logger.info(logString);
		}
	}
	
	public void logStatement(String statement) {
		String logStatement = "Statement "+getClass().getSimpleName()+": "+statement;
		log(logStatement);
	}
}
