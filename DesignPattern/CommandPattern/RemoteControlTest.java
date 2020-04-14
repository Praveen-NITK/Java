package DesignPattern.CommandPattern;
public class RemoteControlTest{
    public static void main(String[] args) {
        SimpleRemoteControl remote= new SimpleRemoteControl();
        Light light= new Light("Living Room");
        LightOffCommand lightOff= new LightOffCommand(light);
        remote.setCommand(lightOff);

        remote.buttonWasPressed();
        remote.undoWasPressed();
    }
}