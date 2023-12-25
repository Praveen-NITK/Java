package org.practice.ArrayPrograms;

import java.util.Stack;
//https://www.hackerrank.com/challenges/java-1d-array/problem

/**
 * In other words, you can move from index i to index i+1,i-1 , or i+leap  as long as the destination index is a cell containing a . If the destination index is greater than n-1, you win the game.
 */
public class CanWin {
    public static void main(String[] args) {
        System.out.println(canWin(3,new int[]{0,0,1,1,0,0}));
    }
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        Stack<Integer> stack= new Stack<>();
        int i=0;
        stack.push(i);
        while(!stack.isEmpty())
        {
            i=stack.pop();
            //Making its visited kind of
            game[i]=-1;

            if(i+leap>=game.length||i+1>=game.length)
                return true;
                                // and not visited
            if(game[i+1]==0 && game[i+1]!=-1)
                stack.push(i+1);
                                // and not visited
            if(game[i+leap]==0 && game[i+leap]!=-1)
                stack.push(i+leap);
                                // and not visited
            if(i!=0 && game[i-1]==0 && game[i-1]!=-1)
                stack.push(i-1);
        }
        return false;
    }
}
