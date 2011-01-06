package net.form105.rm.server.ant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.attribute.AbstractAttribute;

public class Workflow extends AgentObject {
	
	private static final long serialVersionUID = 1671714225911687893L;
	
	private String type;
	private long creationTime = 0;
	
	private Map<String, Task> taskMap = new HashMap<String, Task>();
	private List<AbstractAttribute<?>> attributeList = new ArrayList<AbstractAttribute<?>>();
	
	
	public Workflow(String id, String name, String type) {
		this.creationTime = System.currentTimeMillis();
		super.setElementId(id);
		super.setName(name);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public Task getTask(String id) {
		return taskMap.get(id);
	}
	
	public void addTask(Task task) {
		taskMap.put(task.getElementId(), task);
	}
	
	public void removeTask(Task task) {
		taskMap.remove(task.getElementId());
	}
	
	public long getCreationTime() {
		return creationTime;
	}
	
	public void addAttribute(AbstractAttribute<?> attribute) {
		attributeList.add(attribute);
	}
	
	public AbstractAttribute<?> getAttributeById(String id) {
		for (AbstractAttribute<?> attribute : attributeList) {
			if (attribute.getElementId().equals(id)) return attribute;
		}
		return null;
	}
}
