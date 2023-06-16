package org.practice.DesignPattern.IteratorPattern;

import java.util.ArrayList;

public class PanCakeHouseMenu implements Menu{
    ArrayList<MenuItem> menuItems;
    public PanCakeHouseMenu(){
        menuItems= new ArrayList<>();
    
        addItem("abc", "abc....",10.0,true);
        addItem("aabbcc", "aabbcc....",5.0,false);
        addItem("xyz", "xyz....",20.0,true);
    }
    public void addItem(String name, String description, double price, boolean vegetarian){
        MenuItem menuItem= new MenuItem(name,description, price,vegetarian);
        menuItems.add(menuItem);
    }
    // public ArrayList<MenuItem> getMenuItems(){
    //     return menuItems;
    // }

    public Iterator createIterator(){
        return new PanCakeHouseIterator(menuItems);
    }

}
