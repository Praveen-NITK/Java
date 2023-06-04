package Myntra;
import java.util.List;
public abstract class Vehicle{
    String name;
    int speed;
    int timeToCrossOneSignal;
    List<Driver> driverList;

    public Vehicle(String n, int s, int t){
        name=n;
        speed=s;
        timeToCrossOneSignal=t;
    }
    @Override
    public String toString() {
        return name;
    }
}