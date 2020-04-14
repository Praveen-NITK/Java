package Myntra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Journey{   

    public static void main(String[] args) {

        List<Route> routeLists= new ArrayList<>();
        routeLists.add(new Route("Koramangla",20,60,10));
        routeLists.add(new Route("KR Puram",25,80,5));
        routeLists.add(new Route("MG Road",30,50,8));
        
        Vehicle rapidoBike= new Rapido("Rapido Bike",40,3);
        Vehicle rapidoScooty=new Rapido("Rapido Scooty", 35, 4);
        Vehicle olaAuto= new Cab("Ola Auto",50,5);
        Vehicle olaCab= new Cab("Ola Cab",70,7);

        //Driver's name
        rapidoBike.driverList.add(new Driver("Ram",true,4));
        rapidoBike.driverList.add(new Driver("Ramesh",true,3));
        rapidoBike.driverList.add(new Driver("Rajeev",true,5));
        rapidoBike.driverList.add(new Driver("Rajesh",true,3));
        rapidoScooty.driverList.add(new Driver("Rama",false,5));
        
        Weather sunny= new Weather("Sunny");
        sunny.addVehicleToWeather(rapidoBike);
        sunny.addVehicleToWeather(rapidoScooty);
        sunny.addVehicleToWeather(olaAuto);
        sunny.addVehicleToWeather(olaCab);

        Weather rainy= new Weather("Rainy");
        rainy.addVehicleToWeather(olaAuto);
        rainy.addVehicleToWeather(olaCab);

        Weather windy= new Weather("Windy");
        windy.addVehicleToWeather(rapidoBike);
        windy.addVehicleToWeather(olaCab);

        //Input can be passed as different weather here
        getPerfferedVehicleForWeather(sunny, routeLists);
    }

    private static void getPerfferedVehicleForWeather(Weather weather, List<Route> routes) {
        double leastTime=Double.MAX_VALUE;
        //TreeMap<Integer, String> vehicleVSroute= new TreeMap<>();
        String routeName="";
        String vehicleName="";
        String driverName="";
        for (Route route : routes) {
            for (Vehicle v : weather.eligibleVehicles) {
                double signalCrossTime=route.noOfSignals*v.timeToCrossOneSignal;
                double allowedSpeed=Math.min(v.speed, route.maxSpeed);
                double distanceCovertime=(60.0/allowedSpeed)*route.distance;
                double timeTaken= distanceCovertime+signalCrossTime;
                //System.out.println(timeTaken);
                if(timeTaken<leastTime){
                    leastTime=timeTaken;
                    routeName=route.routeName;
                    vehicleName=v.name;
                    
                    //#region For Driver Information
                    //driverName=v.driverList.stream().filter(x->x.ratings>=4).findFirst().get().name;
                    Collections.sort(v.driverList, new Comparator<Driver>() {
                        @Override
                        public int compare(Driver d1, Driver d2){
                            return d2.ratings - d1.ratings;  // for Reverse Sorting d2-d1
                        }
                    });
                    driverName=v.driverList.get(0).name;
                    //#endregion

                }
            }            
        }

        //Arrays.sort(vehicleVSroute);
        System.out.println("Ride a "+vehicleName+ " Via "+ routeName +" With "+driverName);

    }
}