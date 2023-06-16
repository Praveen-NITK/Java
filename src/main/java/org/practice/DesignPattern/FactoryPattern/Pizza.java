package org.practice.DesignPattern.FactoryPattern;

import java.util.ArrayList;

public class Pizza{
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings=new ArrayList<>();    

    void prepare(){
        System.out.println("Preparing "+name);
        System.out.println("Tossing dough... "+dough);
        System.out.println("Adding Souce... "+sauce);
        System.out.println("Adding Toppings...");
        for (String var : toppings) {
            System.out.println(" "+var);
        }
    }
    void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }
    void cut(){
        System.out.println("Cutting Pizza into diagonal slices");
    }
    void box(){
        System.out.println("Boxing Pizza into official pizzabox");
    }
    public String getName(){
        return this.name;
    }
}
