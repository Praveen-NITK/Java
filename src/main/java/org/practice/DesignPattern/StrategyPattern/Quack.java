package org.practice.DesignPattern.StrategyPattern;
public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}
