package Anagrams;

import java.util.Arrays;

public class AnagramTest {
    public static void main(String[] args) {
        boolean isAnagram=checkIfAnagram("baba","baba");
        boolean isAnagram1=checkIfAnagramWithSort("baba","baba");
        System.out.println("Both words are anagrams: "+ isAnagram);
        System.out.println("Both words are anagrams: "+ isAnagram1);
    }

    protected static boolean checkIfAnagram(String word1,String word2){
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

    //O(NlogN)
    protected static boolean checkIfAnagramWithSort(String word1,String word2){
        if(word1.length()!=word2.length())
            return false;
        char []wordChar1=word1.toCharArray();
        char []wordChar2=word2.toCharArray();
        Arrays.sort(wordChar1);
        Arrays.sort(wordChar2);
        return String.valueOf(wordChar1).equals(String.valueOf(wordChar2));
    }
}
