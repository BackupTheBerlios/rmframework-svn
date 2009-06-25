package net.form105.rm.base.command;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.service.IResult;

public abstract class AbstractCommandHandler<T> implements ICommandHandler<T> {
	
	protected CommandResult<T> result;
	
	public AbstractCommandHandler() {
		result = new CommandResult<T>();
	}
	
	public abstract void execute(List<ICommand> commands);

	public IResult<T> getResult() {
		return result;
	}
	
	public void execute(ICommand command) {
		ArrayList<ICommand> list = new ArrayList<ICommand>();
		list.add(command);
		this.execute(list);
	}

}
