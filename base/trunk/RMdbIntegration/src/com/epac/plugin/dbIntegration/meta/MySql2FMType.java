package com.epac.plugin.dbIntegration.meta;

public enum MySql2FMType {
	
	VARCHAR(12),
	CHAR(4),
	INTUNSIGNED(4),
	ENUM(1),
	FLOAT(7),
	DECIMAL(3),
	DATETIME(93),
	TIMESTAMP(93),
	TEXT(-1),
	UNDEFINED(0);
	
	private int dataType;
	
	private MySql2FMType(int dataType) {
		this.dataType = dataType;
	}
	
	public int getDataType() {
		return dataType;
	}

}
