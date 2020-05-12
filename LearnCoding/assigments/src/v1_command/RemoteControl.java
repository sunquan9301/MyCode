package v1_command;

public class RemoteControl {
 
	private Command[] onCommands;	 
	private Command[] offCommands;	
	private Command thePreviousCommand; 
	 
	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
	 
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		this.thePreviousCommand = onCommands[slot];
	}
	 
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		this.thePreviousCommand = offCommands[slot];
	}
	
	public void undo() {
		this.thePreviousCommand.undo();
	}
	 
}
 
