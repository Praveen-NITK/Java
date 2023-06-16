package org.practice.Recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        TOI('S','D','A', 3);
    }

    private static void TOI(char S, char D, char A, int n) {
        if(n<=0){
            return;
        }
        TOI(S, A, D, n-1);
        System.out.println("Move disk "+n+" from "+S+" to "+D);
        TOI(A, D, S, n-1);
    }
}
