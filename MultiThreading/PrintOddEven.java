package MultiThreading;
////https://www.geeksforgeeks.org/inter-thread-communication-java/
public class PrintOddEven{
    public static void main(String[] args) throws InterruptedException{
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
        int N=20;
        void printEven() throws InterruptedException{
            synchronized(this){      
                notify();               
                for (int i = 0; i < N; i++) {
                    if(i%2==0)
                        System.out.println("Even "+i);
                    wait();
                    notify();
                }                
            }
        }

        void printOdd() throws InterruptedException{
            synchronized(this){                     
                for (int i = 0; i < N; i++) {
                    if(i%2!=0)
                        System.out.println("Odd "+i);
                    wait();
                    notify();
                }                
            }
        }
    }
}