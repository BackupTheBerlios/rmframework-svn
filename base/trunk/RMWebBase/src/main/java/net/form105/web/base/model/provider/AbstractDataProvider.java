package net.form105.web.base.model.provider;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;

public abstract class AbstractDataProvider<T> extends SortableDataProvider<T> {

	private static final long serialVersionUID = 1L;
	
	List<T> inputList = new ArrayList<T>();
	
	public void addInput(T object) {
		inputList.add(object);
	}
	
	public void removeInput(T removableObject) {
		
		if (inputList.contains(removableObject)) {
			inputList.remove(removableObject);
		}
	}
	
	public List<T> getInput() {
		return inputList;
	}
	
	protected void setInput(List<T> inputList) {
		this.inputList = inputList;
	}
	
	public void changeInput(T sourceObject, T targetObject) {
		int foundIndex = inputList.indexOf(sourceObject);
		if (foundIndex >= 0) {
			inputList.set(foundIndex, targetObject);
		}
		
	}
	
	

}
