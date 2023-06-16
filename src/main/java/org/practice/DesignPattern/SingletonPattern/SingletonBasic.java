package org.practice.DesignPattern.SingletonPattern;
public class SingletonBasic{
    private static SingletonBasic singletonInstance;
    private String instanceName;

    private SingletonBasic(){}

    public static SingletonBasic getInstance(){
        if(singletonInstance==null){
            singletonInstance= new SingletonBasic();
        }
        singletonInstance.instanceName="singleton";
        return singletonInstance;
    }
    public void setInstanceName(String name){
        this.instanceName=name;
    }
    public String getInstanceName(){
        return instanceName;
    }

    public static void main(String[] args) {
        SingletonBasic instance1=SingletonBasic.getInstance();
        System.out.println(instance1.getInstanceName());
        SingletonBasic instance2=SingletonBasic.getInstance();
        instance2.setInstanceName("instance 1");
        System.out.println(instance1.getInstanceName());
    }
}
