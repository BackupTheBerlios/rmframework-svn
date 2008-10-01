package net.form105.rm.base.mapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.command.CommandHandler;
import net.form105.rm.base.mapping.reader.ISequenceReader;
import net.form105.rm.base.model.ParameterizedElement;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.model.parameter.AbstractParameter;
import net.form105.rm.server.command.SaveResourceCommand;
import net.form105.rm.server.mapping.ITemplate;

public class DefaultMapperControl {
	
	private Map<String, ITemplate> templateMap = new HashMap<String, ITemplate>();
	private boolean validate;
	
	/**
	 * Maps a sequence from a sequence reader to a field sequence. The field sequence is provided
	 * by a template registered in the template map. Usually a sequence should be iterated and 
	 * fill up field by field of the template.
	 * @param reader
	 */
	public void map(ISequenceReader reader) {
		
		List<String> inputSequence = reader.readSequence();
		ITemplate template = templateMap.get(reader.getTemplateId());
		List<IField> sequenceList = template.getSequence();
		
		if (validate) {
			// check for mapping the amount of fields from import sequence against template sequence
			// --> compare length
		}
		
		ParameterizedElement pElement = template.getParameterizedElement();
		
		for (int i = 0; i < sequenceList.size(); i++) {
			IField field = sequenceList.get(i);
			field.setValue(inputSequence.get(i));
			
			
			Object object = field.getTarget().getTargetObject();
			if (object instanceof AbstractParameter) {
				pElement.addParameter((AbstractParameter<?>) object);
			}
		}
		CommandHandler<Resource> cHandler = new CommandHandler<Resource>();
		SaveResourceCommand saveCommand = new SaveResourceCommand((Resource) pElement);
		cHandler.execute(saveCommand);
		
	}
	
	
	public void registerTemplate(ITemplate template) {
		templateMap.put(template.getId(), template);
	}
	
	public void unregisterTemplate(ITemplate template) {
		templateMap.remove(template.getId());
	}

}
