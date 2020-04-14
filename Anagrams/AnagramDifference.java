package Anagrams;
//No Broker dot com
//https://www.geeksforgeeks.org/minimum-number-of-manipulations-required-to-make-two-strings-anagram-without-deletion-of-character/
public class AnagramDifference{
    public static void main(String[] args) {
        int diff=anagramDiff("cyb","act");
        System.out.println(diff);
    }

    //O(n)
    private static int anagramDiff(String string1, String string2) {
        int count=0;

        int charCount[]=new int[26];
        for (int i = 0; i < string1.length(); i++) {
            charCount[string1.charAt(i)-'a']++;
        }

        //If char from string2 is not present in charCount []
        for (int i = 0; i < string2.length(); i++) {
            if(charCount[string2.charAt(i)-'a']<=0)
                count++;
        }
        return count;
    }
}