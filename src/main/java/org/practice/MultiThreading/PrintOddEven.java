package org.practice.MultiThreading;
////https://www.geeksforgeeks.org/inter-thread-communication-java/
public class PrintOddEven{
    static int N;
    public static void main(String[] args) throws InterruptedException{
        N=20;
        final PC pc = new PC();

        Thread t1= new Thread(new Runnable(){        
            @Override
            public void run() {
               try {
                   pc.printOdd();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        });
        Thread t2= new Thread(new Runnable(){        
            @Override
            public void run() {
               try {
                   pc.printEven();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        });

        t1.start();
        t2.start();
        //t1.join();
        //t2.join();
    }

    public static class PC{

        int counter=1;
        void printEven() throws InterruptedException{
            synchronized(this){      
                notify();               
                while(counter<N){
                    if(counter%2==1)
                        wait();
                    System.out.println("Even "+counter);
                    counter++;
                    notify();
                }                
            }
        }

        void printOdd() throws InterruptedException{
            synchronized(this){
                while(counter<N){
                    if(counter%2==0)
                        wait();
                    System.out.println("Odd "+counter);
                    counter++;
                    notify();
                }                
            }
        }
    }
}
