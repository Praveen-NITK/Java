package org.practice.Anagrams;

import java.util.Arrays;

public class AnagramTest {
    public static void main(String[] args) {
//        boolean isAnagram=checkIfAnagram("baba","baba");
        boolean isAnagram2=isAnagram("Hello","hello");
//        boolean isAnagram1=checkIfAnagramWithSort("baba","baba");
//        System.out.println("Both words are anagrams: "+ isAnagram);
//        System.out.println("Both words are anagrams: "+ isAnagram1);
        System.out.println("words are : "+isAnagram2);
    }

    private static boolean isAnagram(String a, String b){
        // Complete the function
        int[] temp= new int[26];
        for (char c : a.toLowerCase().toCharArray()) {
            temp[c-'a']++;
        }
        for (char d : b.toLowerCase().toCharArray()) {
            temp[d-'a']--;
        }
        for (int i=0;i< temp.length;i++) {
            if(temp[i]!=0)
                return false;
        }
        return true;
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
