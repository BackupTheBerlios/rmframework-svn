package net.form105.rm.server.ant.command;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.command.ICommandListener;
import net.form105.rm.base.query.DefaultFilterQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.server.ant.AntAgent;
import net.form105.rm.server.ant.Globals;
import net.form105.rm.server.ant.container.WorkflowContainer;
import net.form105.rm.server.ant.filter.WorkflowByAttributeValueFilter;
import net.form105.rm.server.ant.model.ExecutionState;
import net.form105.rm.server.ant.model.Workflow;
import net.form105.rm.server.ant.selection.WorkflowByAttributeSelection;

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
			
			logger.info("run thread");

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


	
	// how to get the workflow with the attribute value of the correct hotfolder in a fast and easy way?
	// get HotfolderByAttributeValueQuery
	@Override
	public void finished(CommandEvent event) {
		// notify the workflow that we are finished
		String hotfolderValue = event.getCommand().getGroup();
		String groupId = event.getCommand().getGroup();
		WorkflowContainer wContainer = (WorkflowContainer) AntAgent.getComponentById("workflows");
		WorkflowByAttributeSelection selection = new WorkflowByAttributeSelection(Globals.ATTRIBUTE_ID_HOTFOLDER, wContainer);
		WorkflowByAttributeValueFilter filter = new WorkflowByAttributeValueFilter(Globals.ATTRIBUTE_ID_HOTFOLDER, hotfolderValue);
		DefaultFilterQuery<Workflow> query = new DefaultFilterQuery<Workflow>(selection);

		LocalQueryHandler queryHandler = new LocalQueryHandler();
		IResult<Workflow> result = queryHandler.executeQuery(query);
	
		if (result.equals(ResultStatus.FAIL)) {
			logger.error("Sorting out. Error in query");
		}
		
		System.out.println("finished invoked");
	}

	@Override
	public void started(CommandEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public Queue<AbstractCallbackCommand> getCommandQueue() {
		return queue;
	}

}
