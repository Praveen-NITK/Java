package org.practice.ArrayPrograms;
//Given a string of 0 and 1
//https://devsolus.com/2022/04/26/minimum-number-of-swaps-required-to-make-a-binary-string-palindrome/?amp=1
public class MinSwapPalindrome {
    public static void main(String[] args) {
//        String s= "1100001";
        String s= "11100010";
        //1110 0010
        int minSwap=findMinSwap(s.toCharArray());
        System.out.println(minSwap);
    }

    private static int findMinSwap(char[] ch) {
        int count=0;
        int n= ch.length;
        for (int i = 0; i < n/2; i++) {
            if(ch[i]!=ch[n-1-i]){
                count+=1;
            }
        }
        //if count is odd and n is even ... no solution
        if(count%2==1 && n%2==0)
            return -1;
        //count is even or n is odd
        return (count+1)/2;
    }
}

//Variation to this prob: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/discuss/2477614/JAVA-Solution-with-easy-to-understand-comments
