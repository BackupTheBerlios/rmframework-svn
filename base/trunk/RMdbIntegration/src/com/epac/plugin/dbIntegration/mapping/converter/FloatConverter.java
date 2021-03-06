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
package com.epac.plugin.dbIntegration.mapping.converter;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Converts a field of a {@link ResultSet} which is a float to a {@link BigDecimal}
 * If you don't want to run in rounding problems its a good idea to use the String
 * constructor of the {@link BigDecimal} instead of providing a double.
 * @author heikok
 */
public class FloatConverter implements IResultSetConverter<BigDecimal>{

	private static final long serialVersionUID = 1L;

	@Override
	public BigDecimal convert(ResultSet rs, String columnName) throws SQLException {
		BigDecimal decimal = rs.getBigDecimal(columnName);
		return decimal;
	}

	@Override
	public String toString(Object object) {
		BigDecimal decimal = (BigDecimal) object;
		
		
		return decimal.toString();
	}
}
