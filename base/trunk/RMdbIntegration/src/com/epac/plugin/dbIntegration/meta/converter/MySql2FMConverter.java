package com.epac.plugin.dbIntegration.meta.converter;

import java.util.Map;


public class MySql2FMConverter implements IDBConverter {
	
	private Map<String, String> typeMap;
	
	public MySql2FMConverter(Map<String, String> typeMap) {
		this.typeMap = typeMap;
	}

	@Override
	public String convert(String sourceString) {
		if (typeMap.containsKey(sourceString)) {
			return typeMap.get(sourceString);
		} else {
			return sourceString;
		}
		
		
	}

}
