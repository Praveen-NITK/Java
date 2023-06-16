//https://www.geeksforgeeks.org/reentrant-lock-java/
package org.practice.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadHello extends Thread{
    static Lock l;
    public void run(){
        try{        
            l=new ReentrantLock();
            if(l.tryLock()){
            System.out.println("Thread is running");
            //l.unlock();
            }
        }
        catch(Exception e){
            System.out.println("Exception is caught");
        }
        finally{
            //l.unlock();
        }
    }
    public static void main(String[] args) {
        //l=new Lock();
        ThreadHello ths= new ThreadHello();
        ths.start();      
        ThreadHello the= new ThreadHello();
        the.start();      
        //th.sleep(2000);
        System.out.println("Thread id is "+ths.getId());
        //System.out.println("hello threading");
    }
}