package com.epac.plugin.dbIntegration.meta.converter;

import java.util.ArrayList;
import java.util.List;

public class ReservedKeywords {
	
	private List<String> keywords = new ArrayList<String>();
	private final String APPENDIX = "_reserved";
	
	public ReservedKeywords() {
		keywords.add("type");
		keywords.add("position");
	}
	
	public boolean isReservedKeyword(String source) {
		for (int i = 0; i < keywords.size(); i++) {
			if (keywords.get(i).equalsIgnoreCase(source)) return true;
		}
		return false;
	}
	
	public String prepareKeyword(String source) {
		if (isReservedKeyword(source)) {
			return source + APPENDIX;
		} else {
			return source;
		}
	}
}
