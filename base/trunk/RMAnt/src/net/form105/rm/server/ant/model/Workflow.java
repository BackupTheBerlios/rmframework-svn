package net.form105.rm.server.ant.model;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.attribute.IAttribute;
import net.form105.rm.base.model.attribute.NullAttribute;

public class Workflow {
	
	private String id;
	private String name;
	private String type;
	private boolean singleRunWorkflow;
	private long creationTime = 0;
	
	private List<Task> taskList = new ArrayList<Task>();
	private List<IAttribute<?>> attributeList = new ArrayList<IAttribute<?>>();
	
	
	public Workflow(String id, String name, String type) {
		this.creationTime = System.currentTimeMillis();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean isSingleRunWorkflow() {
		return singleRunWorkflow;
	}
	
	public void addTask(Task task) {
		taskList.add(task);
	}
	
	public void removeTask(Task task) {
		taskList.remove(task);
	}
	
	public long getCreationTime() {
		return creationTime;
	}
	
	public void addAttribute(IAttribute<?> attribute) {
		attributeList.add(attribute);
	}
	
	public IAttribute<?> getAttributeById(String id) {
		for (IAttribute<?> attribute : attributeList) {
			if (attribute.getId().equals(id)) return attribute;
		}
		return new NullAttribute(id, "fail", "fail");
	}
}
