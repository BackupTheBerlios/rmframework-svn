package net.form105.rm.base.model.workflow;

import net.form105.rm.base.model.AbstractModelMap;

import org.picocontainer.Startable;

/**
 * The workflow encapsulates the workflows in a map and gives access to the
 * individual workflows by their ids. The workflow map can be used on server and
 * client side. On the client side it is a cache for rmi calls. 
 * 
 * 
 * @author heikok
 * 
 */
public class WorkflowMap extends AbstractModelMap<Workflow> implements Startable {

	private static final long serialVersionUID = -5053248069697695094L;
	
	@Override
	public void start() {}

	@Override
	public void stop() {}

}
