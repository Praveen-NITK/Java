package org.practice.DesignPattern.IteratorPattern;
public class Waitress{
    Menu panCakeHouseMenu;
    Menu dinerMenu;
    public Waitress(Menu pmenu, Menu dmenu){
        this.panCakeHouseMenu=pmenu;
        this.dinerMenu=dmenu;
    }
    public void printMenu(){
        Iterator panCakeIterator= panCakeHouseMenu.createIterator();
        Iterator dineIterator= dinerMenu.createIterator();

        System.out.println("----Breakfast----");
        printMenu(panCakeIterator);
        System.out.println("----Lunch----");
        printMenu(dineIterator);
    }
    public void printMenu(Iterator itr){
        while(itr.hasNext()){
            MenuItem menuItem=(MenuItem)itr.next();
            System.out.println("Item Name: "+menuItem.name);
            System.out.println("Item Description: "+menuItem.description);
            System.out.println("Item price: "+menuItem.price);
            System.out.println("Is veg: "+menuItem.vegetarian);
        }
    }
}
