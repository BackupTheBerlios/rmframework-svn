package com.epac.java.converter.fm2prop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class SectionHandler {
	
	
	private Map<String, List> sectionMap = new HashMap<String, List>();
	
	public void addPropertyEntryBySection(PropertyEntry propObject) {
		
		String section = propObject.getSection();
		Collection<String> sectionList = sectionMap.keySet();
		
		if (sectionList.contains(section)) {
			sectionMap.get(section).add(propObject);
		} else {
			List list = new ArrayList();
			list.add(propObject);
			sectionMap.put(section, list);
		}
	}
	
	public String getPropertiesAsString() {
		StringBuffer sBuffer = new StringBuffer();
		Collection<String> sectionList = sectionMap.keySet();
		
		for (String section : sectionList) {
			sBuffer.append("[").append(section).append("]").append("\n");
			List propList = sectionMap.get(section);
			for (Object object : propList) {
				PropertyEntry propEntry = (PropertyEntry) object;
				sBuffer.append(propEntry.toPropertyString()).append("\n");
			}
		}
		return sBuffer.toString();
	}

}
