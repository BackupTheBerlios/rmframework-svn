package net.form105.rm.server.ant.model;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.attribute.AbstractAttribute;
import net.form105.rm.base.model.attribute.NullAttribute;

public class Workflow extends AgentObject {
	
	private static final long serialVersionUID = 1671714225911687893L;
	
	private String id;
	private String name;
	private String type;
	private boolean singleRunWorkflow;
	private long creationTime = 0;
	
	private List<Task> taskList = new ArrayList<Task>();
	private List<AbstractAttribute<?>> attributeList = new ArrayList<AbstractAttribute<?>>();
	
	
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
	
	public void addAttribute(AbstractAttribute<?> attribute) {
		attributeList.add(attribute);
	}
	
	public AbstractAttribute<?> getAttributeById(String id) {
		for (AbstractAttribute<?> attribute : attributeList) {
			if (attribute.getElementId().equals(id)) return attribute;
		}
		return new NullAttribute(id, "fail", "fail");
	}
}
