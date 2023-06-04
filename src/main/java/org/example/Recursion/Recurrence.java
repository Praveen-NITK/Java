//T(n)=2T(n/2)+4n
package Recursion;
public class Recurrence{
    public static void main(String[] args) {
        System.out.format("T(n) for %d: is %d",8,solveRecursion(8));
    }

    private static int solveRecursion(int n) {
        if(n==1){
            return 4;
        }
        return 2*solveRecursion(n/2)+4*n;
    }
}