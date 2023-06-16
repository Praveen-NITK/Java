//https://www.geeksforgeeks.org/word-break-problem-dp-32/
package org.practice.MustDo.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WordBreak{
    public static void main(String[] args) {
        String input= "ilike";
        String []wordDict={"i", "like", "ice", "cream", "icecream"};
        boolean canSegmented=canBeSegmented(input, wordDict);
        //boolean canSegmented=canBeSegmentedDP(input, wordDict);
        System.out.println(input+" can be segmented: "+canSegmented); 
    }

    //Refer link at GFG
    private static boolean canBeSegmentedDP(String input, String[] wordDict) {
        if(input.isEmpty()){
            return true;
        }
         if(wordDict.length==0)
            return false;
        
        boolean []wb=new boolean[input.length()+1];
        for (int i = 1; i <= input.length(); i++) {
            if(wb[i]==false && Arrays.asList(wordDict).contains(input.substring(0,i)))
                wb[i]=true;
            if(wb[i]==true){
                if(i==input.length())
                    return true;
                for (int j = i+1; j <=input.length(); j++) {
                    if(wb[j]==false && Arrays.asList(wordDict).contains(input.substring(i,j-1)))
                        wb[j]=true;
                    if(j==input.length() && wb[j]==true)
                        return true;
                }
            }
        }

        return false;
    }

    private static boolean canBeSegmented(String input, String[] wordDict) {
        if(input.isEmpty()){
            return true;
        }
         if(wordDict.length==0)
            return false;        
        //taking each prefix and checking recursively
        for (int i = 1; i <=input.length(); i++) {
            if( Arrays.asList(wordDict).contains(input.substring(0,i)) 
                && canBeSegmented(input.substring(i, input.length()),wordDict))
                return true;     
        }
        return false;
    }
}