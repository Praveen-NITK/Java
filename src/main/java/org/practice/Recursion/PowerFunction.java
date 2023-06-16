package org.practice.Recursion;

/**
 * power(x,n) =
 *
 * 1 if n = 0
 * x · power(x,n−1) otherwise.
 */
public class PowerFunction {
    public static void main(String[] args) {
        long power=computePower(2,3);
        System.out.println(power);
    }

    private static long computePower(int n, int pow) {
        if(pow==0){
            return 1;
        }
        return n*computePower(n,pow-1);
    }
}
