//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
package org.practice.Anagrams;

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
        String []wordList={"cat", "dog", "tac", "god", "act"};
        groupAnagram(wordList);
    }

    private static void groupAnagram(String[] wordList) {
        HashMap<String,List<String>> anagramGroup = new HashMap<>();
        for (int i = 0; i < wordList.length; i++) {

            String word = wordList[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            if(anagramGroup.containsKey(newWord)){
                anagramGroup.get(newWord).add(word);
            }
            else {
                List<String> words = new ArrayList<>();
                words.add(word);
                anagramGroup.put(newWord,words);
            }
        }
        System.out.println(anagramGroup.values());
    }
}