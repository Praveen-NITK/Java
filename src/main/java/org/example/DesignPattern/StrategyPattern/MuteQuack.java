package DesignPattern.StrategyPattern;
public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack Muted!");
    }
}