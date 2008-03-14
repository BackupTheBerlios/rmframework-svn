package com.form105.rm.base.util.text;

import com.form105.rm.base.exception.CircularReferenceException;
import com.form105.rm.base.exception.PropertyNotFoundException;
import com.form105.rm.base.exception.TagNotFoundException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;



/**
 * Reduces a default variable declared by a identifier, a starter and a stopper
 * with a String. The default declaration is ${}
 * @author Heiko Kundlacz
 *
 */
public class VariableSubstituter {
	
	private Logger logger = Logger.getLogger(VariableSubstituter.class);
	
	/**
     * The variable
     */
    public Variable variable;
    
    /**
     * Holds value of property variableKeys to check for circular references
     */
    private ArrayList variableKeys = new ArrayList();
    
    
    /**
     * <p>Searches for a char in a String and return an integer.</p>
     * @param tag the char to find
     * @param parsableString the char array that is searched for occurence of a char
     * @return int index of char that has been found
     * @throws TagNotFoundException Throws exception when the tag doesn't exist
     */
    public int findTagIndex(char tag, char[] parsableString) throws TagNotFoundException {
        int indexTag;
        for (indexTag = 0; indexTag < parsableString.length; indexTag++ ) {
            if (parsableString[indexTag] == tag) {
                return indexTag;
            }
        }
        throw new TagNotFoundException("A tag in the sequence "+parsableString+" wasn't found. Searched Tag: "+tag);
    }
    
    /**
     * Gets the index of variableIdentifier, startTag and endTag
     * @param searchableString The string in which the tags will be searched
     * @param var The variable includes identifier, start and endTag
     * @return The index of found tags
     * @throws TagNotFoundException For not found tags like identifier, start and endTag
     */
    public int[] findVariableIndizes(String searchableString, Variable var) {
        int[] variableIndex = new int[3];
        
        Character identifier = var.getIdentifier();
        Character startTag = var.getStartTag();
        Character endTag = var.getEndTag();
        
        char charSequence[] = {identifier, startTag};
        String varStartSequence = new String(charSequence);
        
        
        
        if (searchableString.contains(varStartSequence)) {
            variableIndex[0] = searchableString.indexOf(varStartSequence);
            variableIndex[1] = variableIndex[0] + 1;
            variableIndex[2] = searchableString.indexOf(endTag, variableIndex[0]);
        } 
        
        return variableIndex;
    }
    
    /**
     * After we got the index replace the variable by searching a property. 
     * Uses the variableKey as the property argument.
     * @param searchableString String where the variable will be searched
     * @param prop A properties object to use for key replacement
     * @param var A custom variable to use for variable search
     * @return The string where the key is replaced
     * @throws CircularReferenceException Will be thrown if a variable references itself
     */
    public String replaceVariable(String searchableString, Variable var, ResourceBundle properties) throws CircularReferenceException, PropertyNotFoundException {
        StringBuffer tempSB;
        String replacedString;
        try {
            int[] found = findVariableIndizes(searchableString, var);
            StringBuffer tempSBuffer = new StringBuffer(searchableString);
            checkCircularReference(tempSBuffer.substring(found[1] + 1,  found[2]));
            
            tempSB = tempSBuffer.replace(found[0],found[2] +1, properties.getString(tempSBuffer.substring(found[1] + 1, found[2])));

            replacedString = replaceVariable(tempSB.toString(), var,  properties);

        } catch (TagNotFoundException tnfe ) {
            return searchableString;
        }
        
        return replacedString;
    }
    
    /**
     * Replaces the key of the variable. The variable is the standard variable,
     * where 
     * identifier = $
     * startTag = {
     * and endTag = }
     * The properties will be used to replace the key.
     * @param searchableString String where the variable will be searched
     * @param prop A properties object to use for key replacement
     * @return The string where the key is replaced
     * @throws CircularReferenceException Will be thrown if a variable references itself
     */
    public String replaceVariable(String searchableString, ResourceBundle prop) {
    	try {
        return replaceVariable(searchableString, new Variable(), prop);
    	} catch (PropertyNotFoundException pnfex) {
    		logger.error("Property not found: "+searchableString);
    		return "";
    	} catch (CircularReferenceException crex) {
    		logger.error("Circular reference found: "+searchableString);
    		return "";
    	} 
    	
    }
    
    /**
     * Replaces a variable with the key by an substitute
     * @param source
     * @param substitute
     * @param key
     * @param var
     * @return
     */
    public String replaceVariable(String source, String substitute, String key, Variable var) {
        getVariable(source, var);
        StringBuffer buffer = new StringBuffer();
        buffer.append(var.getIdentifier());
        buffer.append(var.getStartTag());
        buffer.append(key);
        buffer.append(var.getEndTag());
        
        source.replace(buffer, substitute);
        return source;
        
    }

    
    /**
     * checks for the Object o in the key array. This is for searching circular 
     * references. If a object will be added first check for its existence.
     * @param searchableObject The Object to check for
     * @throws CircularReferenceException Will be thrown if the array already contains this object
     */
    public void checkCircularReference(Object searchableObject) throws CircularReferenceException {
        if (variableKeys.size() == 0 || variableKeys.get(variableKeys.size() - 1) == searchableObject) {
            return;
        }
        if (variableKeys.contains(searchableObject)) {
            throw new CircularReferenceException("CircularReferenceException found on "+searchableObject);
        }
        variableKeys.add(searchableObject);
    }
 
    
    /**
     * 
     * @param source
     * @param var
     * @return
     */
    public Variable getVariable(String source, Variable var) {
        
        int[] indizes = findVariableIndizes(source, var);
        
        if (indizes.length > 0) {
            var.setVariableKey(source.substring(indizes[1]+1, indizes[2]));
        }
        
        return var;
    }
}
