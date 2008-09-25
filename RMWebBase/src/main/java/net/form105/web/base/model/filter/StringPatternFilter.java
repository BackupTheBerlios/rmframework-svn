package net.form105.web.base.model.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.form105.rm.base.util.PatternConverter;

/**
 * 
 * @author hk
 *
 * Takes an input object and matches against an inputPattern which is an expression
 * in the sense of {@link PatternConverter}. This filter requires a {@link IValue}
 * which is a wrapper to provide an abstract value.
 * @param <V> Type of the input object that will be checked
 */
public class StringPatternFilter<T> extends AbstractUIFilter<T, String> {
	

	private static final long serialVersionUID = 1L;

	PatternConverter converter = new PatternConverter();
	private String id = "STRING_PATTERN_FILTER";
	private String configParameter;
	private String name;
	
	private IValue<String, T> value;
	
	/**
	 * Constructs the filter
	 * @param pattern The pattern usually got by the user input
	 * @param value A wrapper for the input object
	 */
	public StringPatternFilter(String id, IValue<String, T> value, String name) {
		this.id = id;
		this.value = value;
		this.name = name;
	}

	@Override
	public boolean filter(T object) {
		
		String sValue = value.getValue(object);
		
		Pattern p = Pattern.compile(converter.convert(configParameter));
		Matcher m = p.matcher(sValue);
		return m.matches();
		
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	

	/**
	 * @return the value
	 */
	public IValue<String, T> getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(IValue<String, T> value) {
		this.value = value;
	}

	@Override
	public String getConfigParameter() {
		return configParameter;
	}

	@Override
	public void setConfigParameter(String configParameter) {
		this.configParameter = configParameter;
	}
	
	
	
	

}
