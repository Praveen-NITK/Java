package Numbers;

public class LCM_GCD{
    public static void main(String[] args) {
        int a=20;
        int b=16;
        long result= calculateGCD(a,b);
        System.out.println("GCD is: "+result);
        System.out.println("LCM is: "+a*b/result);
    }

    private static long calculateGCD(long x, long y) {
        // if(y==0)
        //     return x;
        // return calculateGCD(y,x%y);
        
        if(y==0)
            return x;
        if(x==y)
            return x;
        
        if(x>y)
            return calculateGCD(x-y,y);
        else
            return calculateGCD(x,y-x);
    }
}