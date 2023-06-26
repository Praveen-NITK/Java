package org.practice.Strings;

import java.util.Arrays;
import java.util.List;

public class ReverseWords {
    // Given a sentence reverse the words in it
    public static void main(String[] args) {
        String sentence="Given a sentence reverse the words in it";
        String []words=sentence.split(" ");

        StringBuilder reversedSentence= new StringBuilder();
        Arrays.stream(words).forEach(word->reversedSentence.insert(0,word+" "));

//        int size= words.length;
//        for (int i=size-1; i>=0;i--){
//            reversedSentence.append(words[i]+" ");
//        }

        reversedSentence.deleteCharAt(reversedSentence.length()-1);
        System.out.println(reversedSentence.toString());
        System.out.println("size of sentence: "+sentence.length());
        System.out.println("size of reversed sentence: "+reversedSentence.length());
    }
}
