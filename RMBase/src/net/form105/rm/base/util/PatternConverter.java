package net.form105.rm.base.util;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * Converts a raw string that has * and ? in its sequence to a regular 
 * expression. rawMultipleChar is the character that is a placeholder for
 * character sequences. rawSingleChar is the placeholder for a single
 * character.
 * 
 * @author Heiko Kundlacz
 *
 */
public class PatternConverter implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PatternConverter.class);
    
    public final String multipleChars = ".*";
    public final String singleChar = ".";
    public final String rawMultipleChar = "*";
    public final String rawSingleChar = "?";
    
    public String rawPattern;
    public String pattern;
    
    public PatternConverter() {
        
    }
    
    /**
     * Constructs a Converter
     * @param rawPattern
     */
    public PatternConverter(String rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    /**
     * Converts a raw string to a valid regular expression.
     * @param rawPattern The input to convert
     * @return The converted string
     */
    public String convert(String rawPattern) {
        StringBuilder rawStringBuilder = new StringBuilder(rawPattern);
        rawStringBuilder = replace(rawStringBuilder, multipleChars, rawMultipleChar, 0);
        rawStringBuilder = replace(rawStringBuilder, singleChar, rawSingleChar, 0);
        return rawStringBuilder.toString();
    }
    /**
     * Replaces the findString by replaceString. The start of searching
     * is defined by startIndex.
     * @param rawString The input to replace string
     * @param replaceString The sequence which will put in
     * @param findString The sequence to look for
     * @param startIndex The index to start searching
     * @return
     */
    public StringBuilder replace(StringBuilder rawString, String replaceString, String findString, int startIndex) {
        logger.debug("StringBuilder.rawString: "+rawString);
        if (rawString.indexOf(findString, startIndex) == -1) {
            return rawString;
        }
        int start = rawString.indexOf(findString, startIndex);
        int end = start + findString.length();
        
        rawString = rawString.replace(start, end, replaceString);
        
        startIndex = end + replaceString.length() - findString.length();
        if (rawString.indexOf(findString, startIndex) != -1) {
            
            return replace(rawString, replaceString, findString, startIndex);
        } else {
            return rawString;
        }
    }
    
    public boolean containsWildcardChar(String rawPattern) {
    	return rawPattern.contains(rawMultipleChar) || rawPattern.contains(rawSingleChar);
    }
    
}
