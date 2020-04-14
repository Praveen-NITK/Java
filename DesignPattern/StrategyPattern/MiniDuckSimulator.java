package DesignPattern.StrategyPattern;
public class MiniDuckSimulator{
    public static void main(String[] args) {
        Duck mallard= new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        
        System.out.println("--------------------");

        Duck model = new ModelDuck();
        model.performFly();
        //model.flyBehavior=new FlyRocketPowered();
        model.setFlyBehavior(new FlyRocketPowered());
        //model.setFlyBehavior(new FlyWithWings());
        model.performFly();
    }
}