package v1_command;

public class Test {
	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();
		Light light = new Light();

		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);

		remote.setCommand(0,lightOn,lightOff);
		remote.offButtonWasPushed(0);
		remote.onButtonWasPushed(0);
		remote.undo();
    }
}