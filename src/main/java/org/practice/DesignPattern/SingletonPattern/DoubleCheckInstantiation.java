package org.practice.DesignPattern.SingletonPattern;
public class DoubleCheckInstantiation{
    private volatile static DoubleCheckInstantiation instance;
    private DoubleCheckInstantiation(){}

    public static DoubleCheckInstantiation getInstance(){
        if(instance==null){
            synchronized(DoubleCheckInstantiation.class){
                if(instance==null){
                    instance= new DoubleCheckInstantiation();
                }
            }
        }
        return instance;
    }
}
