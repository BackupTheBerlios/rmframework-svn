package net.form105.rm.server.ant.command;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCommandHandler;
import net.form105.rm.base.command.ICommand;
import net.form105.rm.base.model.ExecutionState;
import net.form105.rm.base.model.attribute.AbstractAttribute;
import net.form105.rm.base.model.workflow.Workflow;
import net.form105.rm.base.model.workflow.WorkflowManager;
import net.form105.rm.base.model.workflow.WorkflowStatus;
import net.form105.rm.base.service.IResult;
import net.form105.rm.server.ant.Globals;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundObject;

import org.apache.log4j.Logger;
import org.picocontainer.Startable;

public class AntCommandHandler extends AbstractCommandHandler<Object> implements Runnable, Startable {

	public static Logger logger = Logger.getLogger(AntCommandHandler.class);

	private ExecutionState currentState = ExecutionState.NotStarted;
	private boolean keepRunning = true;
	private Thread executionThread;
	private IResult<Object> result;
	private IExecutionStrategy strategy;
	
	public AntCommandHandler(IExecutionStrategy strategy) {
		this.strategy = strategy;
	}

	Queue<ICommand> queue = new ConcurrentLinkedQueue<ICommand>();

	/**
	 * If a queue is initialized and contains objects we need to trigger the
	 * first object on the stack.
	 */
	protected void triggerQueue() {

	}

	@Override
	public void execute(ICommand command) {
		addToStack(command);
	}

	@Override
	public void execute(List<ICommand> commands) {
		for (ICommand command : commands) {
			addToStack(command);
		}
	}

	/**
	 * Register a command for execution on the stack - FIFO
	 * 
	 * @param command
	 */
	public void addToStack(ICommand command) {
		queue.add(command);
	}

	public ExecutionState getState() {
		return currentState;
	}

	public void run() {
		while (keepRunning) {
				// using external method for testing purposes
				singleRun();
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void singleRun() {
		AntExecutionCommand command = (AntExecutionCommand) queue.poll();
		if (command != null) {
			if (strategy.isExecutable(command.getInboundObject())) {
				Thread thread = new CommandThread(command);
				thread.start();
			} else {
				queue.add(command);
			}
		}
	}

	public void start() {
		this.keepRunning = true;
		executionThread = new Thread(this);
		executionThread.start();
	}

	public void stop() {
		keepRunning = false;
	}

	public Queue<ICommand> getStack() {
		return queue;
	}

	public IResult<Object> getResult() {
		return result;
	}

	private class CommandThread extends Thread {

		private ICommand command;

		public CommandThread(ICommand command) {
			this.command = command;
		}

		public void run() {
			command.execute();
		}

	}

}
