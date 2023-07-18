package test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.SortedSet;

/**
 * skip if consecutive repeated
 * i/p:aaabbcdygmmmgyebaxx
 * o/p:cdyggyeba
 * final o/p: cdeba
 *
 * b-2
 */
public class Test {
    public static void main(String[] args) {
        String input= "aaabbcdygmmmgyebaxx";
        StringBuilder output=new StringBuilder();

        char last='a';
        int currentCounter=1;
        for (int i = 1; i <input.length() ; i++) {
            if(last==input.charAt(i)){
                currentCounter++;
                last=input.charAt(i);
            }
            else if(currentCounter==1){
                if(output.length()>0 && output.charAt(output.length()-1)==last){
                    output.deleteCharAt(output.length()-1);
                }
                else
                    output.append(last);
                last=input.charAt(i);
            }
            else {
                last = input.charAt(i);
                currentCounter=1;
            }
        }
        System.out.println(output);
    }
}
