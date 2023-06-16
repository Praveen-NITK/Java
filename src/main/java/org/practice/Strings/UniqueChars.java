package org.practice.Strings;
//Check if string has all unique chars, no additional DS
//Wrong Implementation
public class UniqueChars{
    public static void main(String[] args) {
        String input="string";
        boolean isUniq=isUniqueChars(input);
        System.out.println("Input string has all unique chars: "+isUniq);
    }

    private static boolean isUniqueChars(String input) {
        for (char ch : input.toCharArray()) {
            System.out.println(ch%5);
        }
        return false;
    }
}
