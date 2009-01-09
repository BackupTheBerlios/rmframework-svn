package net.form105.web.base.model.filter;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * A TypeFilter takes a mount of config parameters and compares them with the input object.
 * If one of the config parameters matches the entry will be filtered
 * @author heiko
 *
 * @param <I>
 */
public class TypeFilter<I> extends AbstractUIFilter<I, List<String>> {
	
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = Logger.getLogger(TypeFilter.class);
	
	private String id;
	private String name;
	private IValue<List<String>, I> value;
	
	private List<String> configParameter; 
	
	public TypeFilter(String id, IValue<List<String>, I> value, String name) {
		this.id = id;
		this.value = value;
		this.name = name;
	}

	@Override
	public boolean filter(I object) {
		List<String> input = value.getValue(object);
		
		for (String config : configParameter) {
			if (input.contains(config)) { 
				return true; 
			}
		}
		
		return false;
	}

	@Override
	public List<String> getConfigParameter() {
		
		if (configParameter == null) return configParameter;
		
		StringBuffer sb = new StringBuffer();
		for (String config : configParameter) {
			sb.append(":");
			sb.append(config);
			
		}
		logger.info("config parameters-"+sb.toString());
		return configParameter;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setConfigParameter(List<String> object) {
		this.configParameter = object;
		
	}

	@Override
	public IValue<List<String>, I> getValue() {
		return value;
	}

}
