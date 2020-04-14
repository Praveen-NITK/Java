package Numbers;
import java.util.Arrays;

public class Fibonacci{
    private static long arr[];
    public static void main(String[] args) throws Exception {
        arr=new long[46]; //size n+1
        Arrays.fill(arr, -1);
        arr[0]=0;
        arr[1]=1;
        System.out.println(printFibonacci(45));
    }
    
    //0,1,1,2,3,5,8,13
    private static long printFibonacci(int n) throws Exception {
        if(n<0){
            throw new Exception("n numst be positive no");
        }
        //1. Simple iterative Method
        // int x= 0;
        // int y=1;
        // for(int i=1; i<n; i++){
        //     int result=x+y;            
        //     System.out.println(result);
        //     x=y;
        //     y=result;            
        // }

        //2. Recursive memoized nth fibonacci number   
        if(arr[n]!=-1){
            return arr[n];
        }
        return arr[n]=printFibonacci(n-1)+printFibonacci(n-2);        
        
        //3. Memoized DP
        // long arr[]=new long[n];
        // Arrays.fill(arr, 0);
        // arr[0]=0;
        // arr[1]=1;
        // for (int i=2;i<n;i++){
        //     if(arr[i]!=0){
        //         return arr[i];
        //     }
        //     else{
        //         arr[i]=arr[i-1]+arr[i-2];
        //     }
        // }
        // return arr[n-1];

    }
}