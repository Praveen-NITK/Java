package org.practice.JavaConcepts;

import java.util.Arrays;

public class StringJava {
    public static void main(String[] args) {
        //we can create a new character array matching S by using the method, S.toCharArray( )
        String s="bird";
        System.out.println(Arrays.toString(s.toCharArray()));
        //with character
        //array A={'b', 'i', 'r', 'd'}, the syntax new String(A) produces "bird"
        char[] charArray={'p','r','a','v','e','e','n'};
        System.out.println(new String(charArray));
    }
}
