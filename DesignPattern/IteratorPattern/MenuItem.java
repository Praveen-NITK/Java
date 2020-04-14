package DesignPattern.IteratorPattern;
public class MenuItem{
    String name;
    String description;
    double price;
    boolean vegetarian;

    public MenuItem(String n, String d, double p, boolean v){
        name=n;
        description=d;
        price=p;
        vegetarian=v;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return  price;
    }
    public boolean isVegetarian(){
        return vegetarian;
    }
    
}