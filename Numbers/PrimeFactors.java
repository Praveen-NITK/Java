package Numbers;

import java.util.ArrayList;
import java.util.List;
//https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/

public class PrimeFactors{
    public static void main(String[] args) {
        int num=36;
        List<Integer> primeFactors=getPrimeFactorsOf(num);
        for (int i = 0; i < primeFactors.size(); i++) {
            System.out.println(primeFactors.get(i));
        }
    }
    

    private static List<Integer> getPrimeFactorsOf(int num) {
        List<Integer> primeFactors=new ArrayList<>();
        while(num%2==0){
            primeFactors.add(2);
            num=num/2;
        }
        for (int i = 3; i < num; i+=2) {
            while(num%i==0){
                primeFactors.add(i);
                num=num/i;
            }
        }
        if(num>2)
            primeFactors.add(num);
        return primeFactors;
    }
}