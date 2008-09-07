package net.form105.rm.base.mapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SequenceGroup<T extends IField> {
	
	private List<T> sequence = new ArrayList<T>();
	
	public SequenceGroup() {
		
	}
	
	public void addField(T field) {
		sequence.add(field);
	}
	
	public Iterator<T> getIterator() {
		return sequence.iterator();
	}
	
	

}
