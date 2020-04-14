package DesignPattern.CommandPattern;
public class RemoteLoader{
    public static void main(String[] args) {
        RemoteControl remoteControl= new RemoteControl();
        Light livingRoomLight= new Light("LivingRoom");
        Light kitchenLight= new Light("Kitchen");
        CeilingFan kitchenCeilingFan= new CeilingFan("Kitchen");
        CeilingFan livingRoomCeilingFan= new CeilingFan("LivingRoom");
        CeilingFan bedRoomCeilingFan= new CeilingFan("BedRoom");

        LightOnCommand livingRoomLightOnCommand= new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand= new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOnCommand= new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOffCommand= new LightOffCommand(kitchenLight);

        CeilingFanOnCommand kitchenCeilingFanOnCommand= new CeilingFanOnCommand(kitchenCeilingFan);
        CeilingFanOffCommand kitchenCeilingFanOffCommand= new CeilingFanOffCommand(kitchenCeilingFan);

        CeilingFanOnCommand livingRoomCeilingFanOnCommand= new CeilingFanOnCommand(livingRoomCeilingFan);
        CeilingFanOffCommand ivingRoomCeilingFanOffCommand= new CeilingFanOffCommand(livingRoomCeilingFan);

        CeilingFanHighCommand bedCeilingFanHighCommand= new CeilingFanHighCommand(bedRoomCeilingFan);
        CeilingFanLowCommand bedCeilingFanLowCommand= new CeilingFanLowCommand(bedRoomCeilingFan);
        CeilingFanOffCommand bedCeilingFanOffCommand= new CeilingFanOffCommand(bedRoomCeilingFan);

        remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);
        remoteControl.setCommand(2, kitchenCeilingFanOnCommand, kitchenCeilingFanOffCommand);
        remoteControl.setCommand(3, livingRoomCeilingFanOnCommand, ivingRoomCeilingFanOffCommand);

        remoteControl.setCommand(4, bedCeilingFanHighCommand, bedCeilingFanOffCommand);
        remoteControl.setCommand(5, bedCeilingFanLowCommand, bedCeilingFanOffCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(2);
            System.out.println("--undo--");
            remoteControl.undoWasPushed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
            System.out.println("--undo--");
            remoteControl.undoWasPushed();
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);

        System.out.println("--bed--");
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);        
        remoteControl.undoWasPushed();

        remoteControl.onButtonWasPushed(5);
        remoteControl.offButtonWasPushed(5); 
        remoteControl.undoWasPushed();
    }
}