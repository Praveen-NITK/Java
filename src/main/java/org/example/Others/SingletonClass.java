package Others;
public class SingletonClass{
    private static SingletonClass singletonInstance = null;
    private int value=10;

    private SingletonClass(int x){
        value=x;
    }
    private static SingletonClass getSingletonInstance(int x){
        if(singletonInstance==null){
            singletonInstance= new SingletonClass(x);
        }
        return singletonInstance;
    }

    public static void main(String[] args) {
        System.out.println("Expected Output is "+5+" "+10);
        System.out.print( "Actual output is "+getSingletonInstance(5).value);
        System.out.print( " "+ getSingletonInstance(10).value);
    }
}