package DesignPattern.FactoryPattern;
public class ChicagoStylePizzaStore extends PizzaStore{
    public Pizza createPizza(String type){
        if(type.equals("cheese")){
            return new ChicagoStyleCheesePizza();
        }
        // else if(type.equals("veggie")){
        //     pizza=new ChicagoStyleVeggiePizza();
        // }
        else
            return null;
    }
    
    
}