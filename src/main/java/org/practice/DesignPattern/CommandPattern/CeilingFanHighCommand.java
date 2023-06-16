package org.practice.DesignPattern.CommandPattern;
public class CeilingFanHighCommand implements Command{
    CeilingFan clfn;
    int prevSpeed;
    public CeilingFanHighCommand(CeilingFan cfn){
        clfn=cfn;
    }
    public void execute(){
        prevSpeed=clfn.getSpeed();
        clfn.high();
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
