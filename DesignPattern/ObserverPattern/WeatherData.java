package DesignPattern.ObserverPattern;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers= new ArrayList<>();
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        if(observers.contains(o))
            observers.remove(o);
    }

    public void notifyObservers(){        
        for (Observer ob : observers) {
            ob.update(temperature, humidity, pressure);            
        }        
    }

    public void measurementChanges(){
        notifyObservers();
    }

    public void setMeasurements(float temp,float humidity, float pressure){
        this.temperature=temp;
        this.humidity=humidity;
        this.pressure= pressure;
        measurementChanges();
    }

    public void showObserves(){
        for (Observer var : observers) {
            System.out.println("Observer: "+var);
        }
    }
}