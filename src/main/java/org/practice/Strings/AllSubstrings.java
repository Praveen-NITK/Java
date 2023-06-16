package org.practice.Strings;

public class AllSubstrings {
    public static void main(String[] args) {
        String s="java";
        allSubStrings(s);
        System.out.println("-----------");
        allSubStrings(s.toCharArray());
    }

    private static void allSubStrings(String s) {
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                System.out.println(s.substring(i,j));
            }
        }
    }

    private static void allSubStrings(char []input){
        for (int i = 0; i <= input.length; i++) {
            for (int j = i+1; j <= input.length; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(input[k]);
                }
                System.out.println();
            }
        }
    }
}
