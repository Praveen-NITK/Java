package DesignPattern.ObserverPattern;
public class CurrentConditionDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    //Storing a reference to the Subject so that in future we can use it for un-register the dispaly
    private Subject weatherData;

    //Display Element registers itself to weather data
    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }
    public void update(float t, float h, float p){
        this.temperature=t;
        this.humidity=h;
        display();
        deregister();
    }
    public void display(){
        System.out.println("CurrentCondition: "+temperature+"F degrees and "+humidity+"% humidity");
    }
    public void deregister(){
        weatherData.removeObserver(this);
    }
}