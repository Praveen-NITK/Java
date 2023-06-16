package org.practice.Recursion;

public class MultiplicationTable {
    static int i=1;
    public static void main(String[] args) {
        printTableRecursive(5);
    }

    private static void printTableRecursive(int n) {
        if(i>10)
            return;
        System.out.println(n+"*"+i+"= "+n*i++);
        printTableRecursive(n);
    }
}
