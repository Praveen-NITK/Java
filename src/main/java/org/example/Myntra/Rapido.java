package Myntra;

import java.util.ArrayList;
import java.util.List;

public class Rapido extends Vehicle{
    //List<Driver> driverList;
    public Rapido(String n, int s, int t){
        super(n,s,t);
        driverList= new ArrayList<>();
    }

}