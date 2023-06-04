package DesignPattern.StrategyPattern;
public class FlyRocketPowered implements FlyBehavior{
    public void fly(){
        System.out.println( "i am flying with rocket speed");
    }
}