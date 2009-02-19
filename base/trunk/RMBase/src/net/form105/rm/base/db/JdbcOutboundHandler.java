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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.container.DBConnectionPoolContainer;

import org.apache.log4j.Logger;

public class JdbcOutboundHandler {
	
	public static Logger logger = Logger.getLogger(JdbcOutboundHandler.class);
	
	public List<AbstractDBEntity> select(AbstractDBEntity entity) throws SQLException {
		DBConnectionPoolContainer connectionContainer = (DBConnectionPoolContainer) Agent.getContainer(DBConnectionPoolContainer.class);
		Connection connection = connectionContainer.getDefaultConnection();
		String sql = entity.getDialect().concatenateSelectStatement(entity);
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		List<AbstractDBEntity> resultList = new ArrayList<AbstractDBEntity>();
		
		while (rs.next()) {
			AbstractDBEntity newEntity = entity.getNewInstance();
			for (DBColumn col : entity.getColumns()) {
				Object o = col.getConverter().convert(rs, col.getColumnName());
				try {
					Method method = newEntity.getClass().getDeclaredMethod("set"+col.getTargetField(), o.getClass());
					method.invoke(newEntity, o);
					resultList.add(newEntity);
				} catch (SecurityException e) {
					logger.error(e,e);
				} catch (NoSuchMethodException nsme) {
					logger.error(nsme, nsme);
				} catch (IllegalArgumentException iArgEx) {
					logger.error(iArgEx, iArgEx);
				} catch (IllegalAccessException iAccEx) {
					logger.error(iAccEx, iAccEx);
				} catch (InvocationTargetException itex) {
					logger.error(itex, itex);
				}
			}
		}
		return resultList;
	}

}
