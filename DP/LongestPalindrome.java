package DP;
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

public class LongestPalindrome{
    static String input= "forgeeksskeegfor";
    public static void main(String[] args) {
        int longestPalindrome=getLongestPalindrome(0,input.length()-1);
        System.out.println(longestPalindrome);
    }

    private static int getLongestPalindrome(int i, int j) {
        if(i>j)
            return 0;
        if(i==j) return 1;
        if(input.charAt(i) == input.charAt(j))
            return 2+getLongestPalindrome(i+1,j-1);
        else
            return Math.max(getLongestPalindrome(i,j-1), getLongestPalindrome(i+1,j));
    }
}