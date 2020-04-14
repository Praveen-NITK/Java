package DesignPattern.FactoryPattern;
public class ChicagoStyleCheesePizza extends Pizza{
    public ChicagoStyleCheesePizza(){
        name="Chicago style sauce and cheese Pizza";
        dough="Thin Crust Dough";
        sauce="Marina Sauce";
        toppings.add("Grated Raggiano Sauce");
        toppings.add("Kisan Tomato Sauce");
        
        //prepare();
        
    }
    void cut(){
        System.out.println("We dont cut the pizza");
        //System.out.println("Cutting the pizza into square slices");
    }
}