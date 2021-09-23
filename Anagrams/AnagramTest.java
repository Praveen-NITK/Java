package Anagrams;

import java.util.Arrays;

public class AnagramTest {
    public static void main(String[] args) {
        boolean isAnagram=checkIfAnagram("aabb","baba");
        System.out.println("Both words are anagrams: "+ isAnagram);
    }

    private static boolean checkIfAnagram(String word1,String word2){
        if(word1.length()!=word2.length())
            return false;
        int []placeHolder=new int[26];
        for (int i = 0; i <word1.length() ; i++) {
            placeHolder[word1.charAt(i)-'a']++;
        }
        System.out.println(Arrays.asList(placeHolder));
        for (int i = 0; i < word2.length(); i++) {
            if(--placeHolder[word2.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }
}
