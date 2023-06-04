package LambdaBasics;

public class RunnableExample {

    public static void main(String[] args) {
        Thread myThread= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running inside thread");
            }
        });
        myThread.run();

        Thread myLambdaThread=new Thread(()-> System.out.println("My Lambda thread"));
        myLambdaThread.run();
    }
}
