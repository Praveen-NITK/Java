package JavaConcepts;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThredPool {
    static class TreadTest implements Runnable{

        @Override
        public void run() {
            System.out.println("Running this thread "+this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Runnable r1= new TreadTest();
        Runnable r2= new TreadTest();
        Runnable r3= new TreadTest();
        Runnable r4= new TreadTest();
        Runnable r5= new TreadTest();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
    }
}
