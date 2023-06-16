package org.practice.DesignPattern.IteratorPattern;
public class DinerMenu implements Menu{
    static final int MAX_ITEMS=2;
    int noOfItems=0;
    MenuItem[] menuItems;
    
    public DinerMenu(){
        menuItems= new MenuItem[MAX_ITEMS];
        addItem("diner", "abc....",15.0,true);
        addItem("dinner", "xyz....",25.0,false);
    }
    public void addItem(String name, String description, double price, boolean vegetarian){
        MenuItem menuItem= new MenuItem(name,description, price,vegetarian);
        if(noOfItems>=MAX_ITEMS){
            System.out.println("Sorry Menu is FULL");
        }
        else{
            menuItems[noOfItems]=menuItem;
            noOfItems++;
        }      
        
    }
    // public MenuItem[] getMenuItems(){
    //     return menuItems;
    // }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
    
}
