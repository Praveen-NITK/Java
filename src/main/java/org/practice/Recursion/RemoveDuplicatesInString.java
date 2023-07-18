package org.practice.Recursion;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInString {
    public static Set<Character> charSet=new HashSet<>();
    public static void main(String[] args) {
        String s="abbccda"; //abcd
        removeduplicate(s,0,charSet);
    }

    private static void removeduplicate(String s, int index, Set<Character> charSet) {
        if(index==s.length()){
            System.out.println(charSet.toString());
            return;
        }
        if(!charSet.contains(s.charAt(index))){
            charSet.add(s.charAt(index));
        }
        removeduplicate(s,index+1,charSet);
    }
}
