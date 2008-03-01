package com.form105.rm.base.util.text;

/**
 * The variable is identified by a identifier, a start and an end tag. Usually
 * you should use ${} as this is a normal variable sequence. You can set the
 * identifier and tags by system properties:
 * 
 * variable.identifier = $ variable.starttag = { variable.endtag = }
 */
public class Variable {

	/**
	 * Identifier of the variable. Start of the variable. After this tag there
	 * must be a start tag to isolate a variable string.
	 */
	private char identifier = '$';

	/**
	 * Represents the start tag to isolate start of variable
	 */
	private char startTag = '{';

	/**
	 * Represents the end tag to isolate end of variable
	 */
	private char endTag = '}';

	/**
	 * Is value of the key which should be referenced.
	 */
	private String variableKey;

	/**
	 * Getting the start tag of the variable
	 * 
	 * @return a start tag
	 */
	public char getStartTag() {
		return startTag;
	}

	/**
	 * Getting the identifier of the variable
	 * 
	 * @return a identifier for a variable
	 */
	public char getIdentifier() {
		return identifier;
	}

	/**
	 * Set the identifier of the variable.
	 * 
	 * @param aIdentifier
	 *            The identifier which should be set
	 */
	public void setIdentifier(char aIdentifier) {
		identifier = aIdentifier;
	}

	/**
	 * Setting the start tag of the variable
	 * 
	 * @param aStartTag
	 *            The start tag to set
	 */
	public void setStartTag(char aStartTag) {
		startTag = aStartTag;
	}

	/**
	 * Returns the end tag of the variable
	 * 
	 * @return an end tag
	 */
	public char getEndTag() {
		return endTag;
	}

	/**
	 * Sets the end tag of the variable
	 * 
	 * @param aEndTag
	 *            The variable end tag to set
	 */
	public void setEndTag(char aEndTag) {
		endTag = aEndTag;
	}

	/**
	 * Getter for property variableKey.
	 * 
	 * @return Value of property variableKey.
	 */
	public String getVariableKey() {
		return this.variableKey;
	}

	/**
	 * Setter for property variableKey.
	 * 
	 * @param variableKey
	 *            New value of property variableKey.
	 */
	public void setVariableKey(String variableKey) {
		this.variableKey = variableKey;
	}

}
