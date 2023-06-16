package org.practice.Numbers;
public class SumOfN{
    public static void main(String[] args) {
        int n=10;
        int sum=calculateSumR(n);
        System.out.println(sum);
    }

    private static int calculateSumR(int n) {
        if(n<=0)
            return 0;
        return n+calculateSumR(n-1);
    }

    private static int calculateSumI(int n){
        int sum=0;
        for (int i = 1; i <= n; i++) {
            sum=sum+i;
        }
        return sum;
    }
}
