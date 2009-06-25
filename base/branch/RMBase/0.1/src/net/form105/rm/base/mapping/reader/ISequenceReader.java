package net.form105.rm.base.mapping.reader;

import java.util.List;

/**
 * A sequence reader which allows to read a sequence. The sequence is provided as a List which usually 
 * is used to map another object by a template. The sequence here is a sequence of strings which normally 
 * are values that should be mapped to a target.
 * @author hk
 *
 */
public interface ISequenceReader {
	
	/**
	 * An id which represents a template. 
	 * @return The template id
	 */
	public abstract String getTemplateId();

	
	/**
	 * A sequence that can be mapped by a template to a backend object or representative
	 * @return The values to import to backend objects
	 */
	public abstract List<String> readSequence();

}