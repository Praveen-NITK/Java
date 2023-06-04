package DesignPattern.CommandPattern;
public class CeilingFanOnCommand implements Command{
    CeilingFan clfn;
    int prevSpeed;
    public CeilingFanOnCommand(CeilingFan cfn){
        clfn=cfn;
    }
    public void execute(){
        prevSpeed=clfn.getSpeed();
        clfn.on();
    }
    public void undo(){
        if(prevSpeed==CeilingFan.HIGH){
            clfn.high();
        }
        else if(prevSpeed==CeilingFan.MEDIUM){
            clfn.medium();
        }
        else if(prevSpeed==CeilingFan.LOW){
            clfn.low();
        }
        else if(prevSpeed==CeilingFan.OFF){
            clfn.off();
        }
    }
}