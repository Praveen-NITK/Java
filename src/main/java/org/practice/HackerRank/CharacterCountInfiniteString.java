package org.practice.HackerRank;

/**
 * There is a string s , of lowercase English letters that is repeated infinitely many times. Given an integer n , find and print the number of letter a's in the first n letters of the infinite string.
 * Sample Input 0
 *
 * aba
 * 10
 * Sample Output 0
 *
 * 7
 * Explanation 0
 * The first n=10 letters of the infinite string are abaabaabaa. Because there are 7 a's, we return 7.
 */
public class CharacterCountInfiniteString {
    public static void main(String[] args) {
        long count= countCharacterInInfiniteString("aba",10);
        System.out.println(count);
    }

    private static long countCharacterInInfiniteString(String s, long n) {
        long count=countOccurance(s);

        count = count*(n/s.length());
        if(n%s.length()>0){
            count+= countOccurance(s.substring(0, (int) (n%s.length())));
        }
        return count;
    }

    private static int countOccurance(String s){
        int count=0;
        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i)=='a'){
                count++;
            }
        }
        return count;
    }

}
