package net.form105.rm.server.ant.command;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.command.ICommandListener;
import net.form105.rm.server.ant.model.ExecutionState;

import org.apache.log4j.Logger;
import org.picocontainer.Startable;

public class AntCommandHandler implements Runnable, Startable, ICommandListener {

	public static Logger logger = Logger.getLogger(AntCommandHandler.class);

	private ExecutionState currentState = ExecutionState.NotStarted;
	private boolean keepRunning = true;
	private Thread executionThread;

	Queue<AbstractCallbackCommand> queue = new ConcurrentLinkedQueue<AbstractCallbackCommand>();
	

	/**
	 * If a queue is initialized and contains objects we need to trigger the
	 * first object on the stack.
	 */
	protected void triggerQueue() {

	}

	/**
	 * Executes an object from the stack. Takes the first from the queue
	 */
	public void execute(AbstractCallbackCommand command) {
		// There are two types of commands (threaded and synchronized)
		// TODO: implement both versions (threaded and synchronized)
		Thread thread = new Thread(command);
		thread.start();
	}

	/**
	 * Register a command for execution on the stack - FIFO
	 * 
	 * @param command
	 */
	public void addToStack(AbstractCallbackCommand command) {
		queue.add(command);
	}

	public ExecutionState getState() {
		return currentState;
	}

	public void run() {
		while (keepRunning) {
			
			

			AbstractCallbackCommand command = queue.poll();

			// use the workflow map and check if a blocking workflow is running
			// blocking workflow: only one workflow can run on a hotfolder
			if (command != null)
				execute(command);
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// queue execution strategy
	//public void executeStrategy(AbstractCommand command, Queue<AbstractCommand>, ) {
		
	//}

	public void start() {
		this.keepRunning = true;
		executionThread = new Thread(this);
		executionThread.start();
	}

	public void stop() {
		keepRunning = false;
	}


	

	@Override
	public void started(CommandEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void finished(CommandEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public Queue<AbstractCallbackCommand> getCommandQueue() {
		return queue;
	}

	

}
