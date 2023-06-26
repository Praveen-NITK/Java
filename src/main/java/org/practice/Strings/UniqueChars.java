package org.practice.Strings;
//Check if string has all unique chars, no additional DS
public class UniqueChars{
    public static void main(String[] args) {
        String input="string";
        boolean isUniq=isUniqueChars(input);
        System.out.println("Input string has all unique chars: "+isUniq);
    }

    private static boolean isUniqueChars(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j <input.length() ; j++) {
                if (input.charAt(i)==input.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
