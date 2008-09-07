package net.form105.rm.base.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.mapping.reader.IMapperReader;
import net.form105.rm.server.mapping.ITemplateSequence;

public class MapperControl {
	
	private Map<String, ITemplateSequence> templateMap = new HashMap<String, ITemplateSequence>();
	private boolean validate;
	
	public void map(IMapperReader reader) {
		
		List<String> inputSequence = reader.readSequence();
		ITemplateSequence templateSequence = templateMap.get(reader.getTemplateId());
		List<IField> sequenceList = templateSequence.getSequence();
		
		if (validate) {
			// check for mapping the amount of fields from import sequence against template sequence
			// --> compare length
		}
		
		
		
		for (int i = 0; i < sequenceList.size(); i++) {
			IField field = sequenceList.get(i);
			field.setValue(inputSequence.get(i));
		}
		
		// create resources
		
	}
	
	public void registerTemplate(ITemplateSequence sequence) {
		templateMap.put(sequence.getId(), sequence);
	}
	
	public void unregisterTemplate(ITemplateSequence sequence) {
		templateMap.remove(sequence.getId());
	}

}
