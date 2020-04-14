package JavaConcepts.Lambda;
public class RunnableExample{
    public static void main(String[] args) {
        Thread t= new Thread(new Runnable(){
        
            @Override
            public void run() {
                System.out.println("Running thread!");
            }
        });
        t.start();

        Runnable r=()->{
            // Thread t2= new Thread(new Runnable(){
            
            //     @Override
            //     public void run() {
            //         System.out.println("Inner Thread Running");
            //     }
            // });
            //t2.start();

            System.out.println("Hello thread");
        };

        Thread t1= new Thread(()->System.out.println("Running thread with lambda"));
        t1.start();

        Thread test= new Thread(r);
        test.start();
    }
}