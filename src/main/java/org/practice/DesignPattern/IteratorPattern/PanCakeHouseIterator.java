package org.practice.DesignPattern.IteratorPattern;
import java.util.ArrayList;  
public class PanCakeHouseIterator implements Iterator{
    ArrayList<MenuItem> items;
    int position=0;
    public PanCakeHouseIterator(ArrayList<MenuItem> items){
        this.items=items;
    }
    public Object next(){
        MenuItem menuItem= items.get(position);
        position=position+1;
        return menuItem;
    }
    public boolean hasNext(){
        if(position>=items.size() || items.get(position)==null){
            return false;
        }
        else
            return true;
    }
}
