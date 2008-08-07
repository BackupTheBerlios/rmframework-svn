package net.form105.web.base.comparator;

import java.util.Comparator;

/**
 * A simple comparator which takes 2 strings and compares them. The constructor has an argument
 * to choose an ascending oder descending behaviour
 * @author hk
 *
 */
public class StringComparator implements Comparator<String> {
	
	private boolean ascending;
	
	/**
	 * Constructor for default ascending behavior
	 */
	public StringComparator() {
		this(true);
	}
	
	public StringComparator(boolean ascending) {
		this.ascending = ascending;
	}

	@Override
	public int compare(String s1, String s2) {
		int result = s1.compareTo(s2);
		return ascending ? result : -result;
	}

}
