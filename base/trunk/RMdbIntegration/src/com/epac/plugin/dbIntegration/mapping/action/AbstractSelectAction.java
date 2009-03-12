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
package com.epac.plugin.dbIntegration.mapping.action;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epac.plugin.dbIntegration.mapping.AbstractDBEntity;
import com.epac.plugin.dbIntegration.mapping.IDbColumn;
import com.epac.plugin.dbIntegration.mapping.statement.IStatement;

public abstract class AbstractSelectAction implements IJdbcAction {
	
	public static Logger logger = Logger.getLogger(AbstractSelectAction.class);

	@Override
	public abstract List<AbstractDBEntity> execute(AbstractDBEntity entity, Connection connection) throws SQLException;

	@Override
	public abstract String getId();
	
	
	public List<AbstractDBEntity> executeStatement(IStatement statement, AbstractDBEntity entity, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(statement.getStatement(entity.getDialect()).toString());
		ResultSet rs = stmt.executeQuery();

		List<AbstractDBEntity> resultList = new ArrayList<AbstractDBEntity>();
		while (rs.next()) {
			AbstractDBEntity newEntity = entity.getNewInstance();
			for (IDbColumn col : entity.getColumns()) {

				Object o = col.getConverter().convert(rs, col.getDbColumnName());
				if (o == null) continue;
				// logger.debug("Object by rs: "+o+" columnType: "+col.getFieldType()+" colConverter: "+col.getConverter());
				try {
					String targetField = col.getDeclaredField();
					targetField = Character.toUpperCase(targetField.charAt(0)) + targetField.substring(1);
					
					Method method = newEntity.getClass().getDeclaredMethod("set" + targetField, o.getClass());
					method.invoke(newEntity, o);

				} catch (Exception e) {
					logger.error(e, e);
				}
			}
			resultList.add(newEntity);
		}
		return resultList;
	}
	

}
