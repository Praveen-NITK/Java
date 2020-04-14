package DesignPattern.StrategyPattern;
public class MallardDuck extends Duck{
    public MallardDuck(){
        setQuackBehavior(new Quack());
        //quackBehavior= new Quack();
        setFlyBehavior(new FlyWithWings());
        //flyBehavior= new FlyWithWings();
    }
    public void display(){
        System.out.println("I am a real Mallard Duck");
    }
}