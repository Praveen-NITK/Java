package DesignPattern.StrategyPattern;
public class ModelDuck extends Duck{
    public ModelDuck(){
        //flyBehavior=new FlyNoWay();
        //quackBehavior= new Quack();
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyNoWay());
    }
    public void display(){
        System.out.println("I am a model duck");
    }
}