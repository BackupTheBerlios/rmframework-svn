package net.form105.rm.server.ant.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import net.form105.rm.base.service.IResult;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ExecutionHandler {
	
	BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();
	
	public ExecutionHandler() {
		triggerQueue();
	}
	
	/**
	 * If a queue is initialized and contains objects we need to trigger the first object on the stack.  
	 */
	protected void triggerQueue() {
		
	}
	
	/**
	 * Executes an object from the stack. Takes the first from the queue
	 */
	private IResult<?> executeFromStack() {
		Object object = queue.poll();

		throw new NotImplementedException();
	}
	
	// register new objects for execution in queue
	
	
	// register object for execution state event with state objects
	// sends event objects to oberserver
	
	public void addToStack(Object object) {
		queue.add(object);
		executeFromStack();
	}

}
