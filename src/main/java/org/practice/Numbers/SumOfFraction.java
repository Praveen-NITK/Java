package org.practice.Numbers;
//https://www.geeksforgeeks.org/program-to-add-two-fractions/
public class SumOfFraction{
    public static void main(String[] args) {
        int []fraction1={1,3};
        int []fraction2={3,9};
        int []result=getSumOfFractions(fraction1,fraction2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] getSumOfFractions(int[] fraction1, int[] fraction2) {
        int []result= new int[2];
        int hcf=HCF(fraction1[1],fraction2[1]);
        int LCM=getLCM(fraction1[1],fraction2[1],hcf);
        result[0]=(fraction1[0]*(LCM/fraction1[1]) + fraction2[0]*(LCM/fraction2[1]))/hcf;
        result[1]=LCM/hcf;
        return result;
    }

    private static int getLCM(int i, int j, int hcf) {
        
        return i*j/hcf;
    }

    private static int HCF(int x, int y) {
        if(y==0 || x==y)
            return x;
        if(x>y)
            return HCF(x-y, y);
        else 
            return HCF(x, y-x);
    }
}
