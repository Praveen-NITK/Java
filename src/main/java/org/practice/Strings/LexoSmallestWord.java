package org.practice.Strings;

//https://www.geeksforgeeks.org/lexicographically-smallest-string-formed-by-removing-at-most-one-character/
//Lexicographically smallest string formed by removing at most one character
public class LexoSmallestWord {
    public static void main(String[] args) {
        String s="abpdazb";
        System.out.println(smallWord(s));
    }

    private static String smallWord(String s) {
        StringBuilder word= new StringBuilder(s);
        for (int i = 0; i < s.length()-1; i++) {
            // finding first location where its bigger
            if(s.charAt(i)> s.charAt(i+1)) {
                word.deleteCharAt(i);
                return word.toString();
            }
        }
        return s.substring(0,s.length()-1);
    }
}
