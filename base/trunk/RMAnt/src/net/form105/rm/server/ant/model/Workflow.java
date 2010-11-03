package net.form105.rm.server.ant.model;

import java.util.ArrayList;
import java.util.List;

public class Workflow {
	
	private String id;
	private String name;
	private String type;
	private boolean singleRunWorkflow;
	private long creationTime = 0;
	
	public Workflow(String id, String name, String type) {
		this.creationTime = System.currentTimeMillis();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	
	private List<Task> taskList = new ArrayList<Task>();
	
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
}
