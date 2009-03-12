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
package com.epac.plugin.dbIntegration.mapping.converter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Converts a field from a {@link ResultSet} to a double
 * @author heikok
 *
 */
public class IntegerConverter implements IResultSetConverter<Integer> {


	private static final long serialVersionUID = 1L;

	@Override
	public Integer convert(ResultSet rs, String columnName) throws SQLException {
		Integer integerValue = rs.getInt(columnName);
		return integerValue;
	}

	@Override
	public String toString(Object object) {
		Integer intValue = (Integer) object;
		return intValue.toString();
	}

}
