//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
package Anagrams;

import java.util.HashMap;

public class GroupAnagrams{
    public static void main(String[] args) {
        String []wordList={"cat", "dog", "tac", "god", "act"};
        printGroupedAnagrams(wordList);
    }

    //Failsfor "aabbca","babbab" with hashcode method
    private static void printGroupedAnagrams(String[] wordList) {
        HashMap<Integer,String> hm= new HashMap<>();
        for (String word : wordList) {
            if(hm.containsKey(getHashCode(word)))
                hm.put(getHashCode(word),  hm.get(getHashCode(word))+" "+word);
            else{
                hm.put(getHashCode(word),  word);
            }
        }
        System.out.println(hm);
    }

    private static int getHashCode(String word) {
        int hascode=0;
        for (int i = 0; i < word.length(); i++) {
            hascode+=word.charAt(i);
        }
        return hascode;
    }
}