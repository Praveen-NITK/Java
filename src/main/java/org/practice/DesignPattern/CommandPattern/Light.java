package org.practice.DesignPattern.CommandPattern;
public class  Light{
    private String lightName;
    public Light(String name){
        this.lightName=name;
    }
    public void on(){
        System.out.println(lightName+" Light is On");
    }
    public void off(){
        System.out.println(lightName+" Light is Off");
    }
}
