package Recursion;

import java.util.Arrays;

public class Fibbonacci {
    public static void main(String[] args) {

        System.out.println(fibonacciGood(45)[0]);
        System.out.println(fibonacciBad(45));
    }
//0,1,1,2,3,5,8,13,21
    //O(2^n)
    private static long fibonacciBad(int n) {
        if(n<=1)
            return n;
        return fibonacciBad(n-1)+fibonacciBad(n-2);

    }
//O(n)
    private static long[] fibonacciGood(int n) {
        if(n<=1){
            long[] answer={n,0};
            return answer;
        }
        else {
            long[] temp=fibonacciGood(n-1);
            long[] answer={temp[0]+temp[1],temp[0]};
            return answer;
        }
    }
}
