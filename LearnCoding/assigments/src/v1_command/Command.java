package v1_command;

public interface Command {
 
	public abstract void execute();
	public abstract void undo();
}
 
