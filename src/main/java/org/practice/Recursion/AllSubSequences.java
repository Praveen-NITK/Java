package org.practice.Recursion;

public class AllSubSequences {
    public static void allSubsequence(String s, int index, String newString){
        if(index==s.length()){
            System.out.println(newString);
            return;
        }
        char currentChar= s.charAt(index);

        //currentChar to be part of newString
        allSubsequence(s,index+1,newString+currentChar);

        //currentChar not to be part of newString
        allSubsequence(s,index+1,newString);

    }

    public static void main(String[] args) {
        String s= "abc";
        allSubsequence(s,0,"");

    }
}
