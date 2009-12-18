package com.epac.java.converter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class ArgumentMap {
	
	private Map<String, Argument> args = new HashMap<String, Argument>();
	
	public void addArgument(String key, Argument arg) {
		args.put(key, arg);
	}
	
	public Collection<Argument> getArgumentAsList() {
		return args.values();
	}
	
	public String getArgumentValue(String key) {
		if (args.get(key) == null) return "notProvided";
		String value = args.get(key).getValue();
		return value;
	}
	
	public boolean containsKey(String key) {
		return args.containsKey(key);
	}
	
	
}
