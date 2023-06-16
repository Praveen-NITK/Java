package org.practice.DesignPattern.SingletonPattern;
public class EagerInstantiatedSingleton{
    private static EagerInstantiatedSingleton  instance= new EagerInstantiatedSingleton();
    private EagerInstantiatedSingleton(){}

    public static EagerInstantiatedSingleton getInstance(){
        return instance;
    }
}
