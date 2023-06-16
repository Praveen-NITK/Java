package org.practice.DesignPattern.DecoratorPattern;
public abstract class Beverage{
    String description= "Unknown Bevarage";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
