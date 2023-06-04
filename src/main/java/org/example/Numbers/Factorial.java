package Numbers;
import java.util.Arrays;

public class Factorial{
    private static long arr[];
    public static void main(String[] args) throws Exception {      
        long result= getFactorialRecursive(18);
        //long result= getFactorialIterative(50);

        arr=new long[100];
        Arrays.fill(arr, -1);
        arr[0]=1;
        //long result= getFactorialMemoized(17);

        System.out.println("Factorial is : "+result );
    }

    private static long getFactorialIterative(int n) throws Exception {
        if(n<0){
            throw new Exception("Number must be positive");
        }
        long fact=1;
        while(n>0){
            fact*=n;
            n--;
        }
        return fact;
    }

    private static long getFactorialRecursive(int n) throws Exception {        
        if(n<0){
            throw new Exception("Number must be positive");
        }
        if(n==0 || n==1){
            return 1;
        }
        //TimeUnit.SECONDS.sleep(3);
        return n*getFactorialRecursive(n-1);
    }

    private static long getFactorialMemoized(int n) throws Exception{
        if(n<0){
            throw new Exception("Number must be positive");
        }
        for(int i=1;i<=n;i++){
            arr[i]=arr[i-1]*i;
        }
        return arr[n];
    }
}