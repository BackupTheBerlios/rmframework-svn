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
public class StringPatternFilter<V> extends AbstractUIFilter<V> {
	

	private static final long serialVersionUID = 1L;

	PatternConverter converter = new PatternConverter();
	private String id;
	private String inputPattern;
	
	private IValue<String, V> value;
	
	/**
	 * Constructs the filter
	 * @param pattern The pattern usually got by the user input
	 * @param value A wrapper for the input object
	 */
	public StringPatternFilter(String id, String pattern, IValue<String, V> value) {
		this.id = id;
		this.inputPattern = pattern;
		this.value = value;
	}

	@Override
	public boolean filter(V object) {
		
		String sValue = value.getValue(object);
		
		Pattern p = Pattern.compile(converter.convert(inputPattern));
		Matcher m = p.matcher(sValue);
		return m.matches();
		
	}

	@Override
	public String getId() {
		return id;
	}
	
	

}
