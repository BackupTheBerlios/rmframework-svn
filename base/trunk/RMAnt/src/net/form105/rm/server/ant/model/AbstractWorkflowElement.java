package net.form105.rm.server.ant.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorkflowElement implements IModelObject, Serializable {
	
	private static final long serialVersionUID = -663894453799798995L;
	
	private List<IModelObject> children;
	private IModelObject parent;
	private String id;
	private String name;
	
	public AbstractWorkflowElement(String id, String name) {
		this.id = id;
		this.name = name;
		children = new ArrayList<IModelObject>();
	}
	
	public List<IModelObject> getChildren() {
		return children;
	}
	
	public void addChild(IModelObject child) {
		children.add(child);
	}
	
	public IModelObject getParent() {
		return parent;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * If we haven't any children, this is a task. If we have children, this is a workflow
	 * @return
	 */
	public boolean hasChildren() {
		return children.size() > 0;
	}
	
	public boolean isRoot() {
		return getParent() == null;
	}
}
