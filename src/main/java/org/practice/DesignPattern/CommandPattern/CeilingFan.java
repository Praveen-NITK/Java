package org.practice.DesignPattern.CommandPattern;

public class CeilingFan{
    private String name;
    public static final int HIGH=3;
    public static final int MEDIUM=2;
    public static final int LOW=1;
    public static final int OFF=0;
    int speed;
    String position;
    public CeilingFan(String name){
        this.name=name;
    }
    public void on(){
        System.out.println(name+" Ceiling Fan is On");
    }
    public void off(){
        System.out.println(name+" Ceiling Fan is Off");
    }
    public void high(){
        speed=HIGH;
        System.out.println(name+" Ceiling Fan is On speed "+speed);
    }
    public void medium(){
        speed=MEDIUM;
        System.out.println(name+" Ceiling Fan is On speed "+speed);
    }
    public void low(){
        speed=LOW;
        System.out.println(name+" Ceiling Fan is On speed "+speed);
    }
    public int getSpeed(){
        return speed;
    }
}
