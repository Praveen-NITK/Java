//https://www.geeksforgeeks.org/must-coding-questions-company-wise/#google
//https://practice.geeksforgeeks.org/problems/jumping-numbers/0#ExpectOP
//https://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/
package org.practice.MustDo.Google;

import java.util.ArrayList;
import java.util.List;

public class JumpingNumbers{
    public static void main(String[] args) {
        printJumpingNumbers(500);        
    }

    private static void printJumpingNumbers(int num) {
        for (int i = 0; i <= num; i++) {
            if(i<=10){
                System.out.print(i+" ");
            }
            else{
                List<Integer> remainderList=new ArrayList<>();
                int tempNum=i;
                while(tempNum>0){
                    remainderList.add(tempNum%10);
                    tempNum=tempNum/10;
                }
                int j;
                for (j = 1; j < remainderList.size(); j++) {
                    if (Math.abs(remainderList.get(j-1)-remainderList.get(j))!=1) {
                        break;
                    }
                    else{
                        continue;
                    }                    
                }
                if(j==remainderList.size())
                    System.out.print(i+ " ");
            }
        }
    }
}