package Anagrams;

import java.util.HashMap;

public class TestGroupAnagram {
    public static void main(String[] args) {
        String []words= new String[]{"cat","act","tac","god","dog"};
        groupAnagram(words);
    }

    private static void groupAnagram(String[] words) {
        HashMap <Integer,String> hm = new HashMap<>();
        for (String word : words) {
            if(hm.containsKey(getHashCode(word))){
                hm.put(getHashCode(word),hm.get(getHashCode(word))+" "+word);
            }
            else {
                hm.put(getHashCode(word), word);
            }
        }
        System.out.println(hm);
    }

    private static int getHashCode(String word) {
        int hashcode=0;
        for (int i = 0; i < word.length(); i++) {
            hashcode+=word.charAt(i);
        }
        return hashcode;
    }
}
