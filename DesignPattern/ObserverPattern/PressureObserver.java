package DesignPattern.ObserverPattern;
public class PressureObserver implements Observer, DisplayElement{
    private float temperature;
    private float pressure;

    //Display Element registers itself to weather data
    public PressureObserver(WeatherData w){
        w.registerObserver(this);
    }
    
    public void update(float t, float h, float p){
        this.temperature=t;
        this.pressure=p;
        display();
    }
    public void display(){
        System.out.println("CurrentCondition: "+temperature+"F degrees and "+pressure+"% pressure");
    }
}