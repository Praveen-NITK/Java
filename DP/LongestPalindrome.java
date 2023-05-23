package DP;
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

public class LongestPalindrome{
    static String input= "forgeksskeegfor";
//    static String input= "wrow";
    public static void main(String[] args) {
        String result = getLongestPalindromeSubString(input);
        System.out.println(result);
        System.out.println(result.length());
//        String result1 = getLongestPalindromeSubStringDP(input);
//        System.out.println(result1);
//        System.out.println(result1.length());
    }

    //O(N^3)
    private static String getLongestPalindromeSubString(String input) {
        int maxLength=Integer.MIN_VALUE;
        String result="";
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j <= input.length(); j++) {
                String sbs=input.substring(i,j);
                if(isPalindrome(sbs)){
                    int size=j-i;
                    if(size>maxLength){
                        result=sbs;
                        maxLength=size;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String sbs) {
        int start=0;
        int end=sbs.length()-1;
        while (start<end){
            if(sbs.charAt(start)!=sbs.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    private static String getLongestPalindromeSubStringDP(String str){
        int n= str.length();
        boolean [][]dp= new boolean[n][n];

        int maxLength=1;
        //All substrings of length 1 are palindrome (diagonal elements)
        for (int i = 0; i < n; i++) {
            dp[i][i]=true;
        }

        //For substring of length 2
        int start=0;
        for (int i = 0; i < n-1 ; i++) {
            if(str.charAt(i)==str.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                maxLength=2;
            }
        }

        //k is length of substring
        for (int k = 3; k <=n ; k++) {

            //Fix starting index i of substring
            for (int i = 0; i < n-k+1; i++) {
                //j is ending index of substring
                int j=i+k-1;
                if(dp[i+1][j-1] && str.charAt(i)==str.charAt(j)){
                    dp[i][j]=true;
                    if(k>maxLength) {
                        start =i;
                        maxLength = k;
                    }
                }
            }
        }
        return str.substring(start,start+maxLength);
    }
}