//https://www.geeksforgeeks.org/functional-interfaces-java/
// A functional interface is an interface that contains only one abstract method. 
//They can have only one functionality to exhibit. From Java 8 onwards, 
//lambda expressions can be used to represent the instance of a functional interface. 
//A functional interface can have any number of default methods. Runnable, ActionListener, Comparable 
//are some of the examples of functional interfaces.
package org.practice.JavaConcepts;
interface FuncInterface{
    void abstractFun(int x, int y);
//    void abstractFun1(int x);
    default void normalFun(){
        System.out.println("Hello");
    }
}

public class FunctionalInterface{
    public static void main(String[] args) {
        FuncInterface fobj=(x,y)->System.out.println(2*x);

        fobj.abstractFun(5,4);

        //FuncInterface sqr=x->System.out.println(x*x);
        //sqr.normalFun();
    }
}