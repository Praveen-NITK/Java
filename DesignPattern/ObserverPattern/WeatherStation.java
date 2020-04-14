package DesignPattern.ObserverPattern;
import DesignPattern.ObserverPattern.CurrentConditionDisplay;
public class WeatherStation{
    public static void main(String[] args) {
        WeatherData weatherData= new WeatherData();

        //Display Element registers itself (in constructor) to weather data so not registering here, 
        CurrentConditionDisplay cd= new CurrentConditionDisplay(weatherData);
        PressureObserver po= new PressureObserver(weatherData);                
        weatherData.setMeasurements(80, 65, 30);

        weatherData.showObserves();

    }
}