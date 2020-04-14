package Myntra;
import java.util.ArrayList;
import java.util.List;
public class Weather{
    String name;
    List<Vehicle> eligibleVehicles= new ArrayList<>();
    public Weather(String n){
        name=n;
    }

    public void addVehicleToWeather(Vehicle v){

        eligibleVehicles.add(v);
    }
    
}