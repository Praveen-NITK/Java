package org.practice.Numbers;
public class FactN{
    public static void main(String[] args) {
        int number=18;
        // int factorialAnswer= factorial(number);
        // System.out.println("Factorial is: "+factorialAnswer);

        int fibonacciresult= findFibonacci(number);
        System.out.println("Fobonacci number is: "+fibonacciresult);
    }
    
    private static int findFibonacci(int number) {
        int result=0;
        int last=1;
        int seclast=0;

        while(number>1){
            result= last+seclast;
            seclast= last;
            last= result;
            number--;
        }       
        return result;
    }

    public static int factorial(int n) {
        int fact=1;
        // for(int i=n; i>0; i--){
        //     fact=fact*i;
        // }

        // while(n>0){
        //     fact=fact*n--;
        // }

        for (int i = 1; i <= n; i++) {
            fact=fact*i;
        }

        return fact;
    }
}
