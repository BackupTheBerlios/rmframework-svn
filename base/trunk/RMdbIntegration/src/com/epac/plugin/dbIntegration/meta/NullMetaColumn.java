package com.epac.plugin.dbIntegration.meta;

public class NullMetaColumn extends MetaColumn {

	public NullMetaColumn() {
		super("NULL","NULL", MetaType.UNDEFINED, false, -1);
	}
	
	public final boolean isNull() {
		return true;
	}
	
}
