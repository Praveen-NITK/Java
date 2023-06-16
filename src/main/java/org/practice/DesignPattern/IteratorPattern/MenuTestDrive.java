package org.practice.DesignPattern.IteratorPattern;
public class MenuTestDrive{
    public static void main(String[] args) {
        PanCakeHouseMenu panCakeHouseMenu=new PanCakeHouseMenu();
        DinerMenu dMenu= new DinerMenu();
        Waitress waitress= new Waitress(panCakeHouseMenu, dMenu);
        waitress.printMenu();
    }
}
