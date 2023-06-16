package org.practice.DesignPattern.CommandPattern;
public class CeilingFanOffCommand implements Command{
    CeilingFan clfn;
    int prevSpeed;
    public CeilingFanOffCommand(CeilingFan cfn){
        clfn=cfn;
    }
    public void execute(){
        prevSpeed=clfn.getSpeed();
        clfn.off();
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
