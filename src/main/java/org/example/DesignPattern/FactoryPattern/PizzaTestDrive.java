package DesignPattern.FactoryPattern;
public class PizzaTestDrive{
    public static void main(String[] args) {
        PizzaStore chicagoStore=new ChicagoStylePizzaStore();
        Pizza pizza= chicagoStore.orderPizza("cheese");
        System.out.println("I ordered a "+pizza.getName());
        //pizza.cut();
        
    }
}