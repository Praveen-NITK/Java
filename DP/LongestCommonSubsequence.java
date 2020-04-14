package DP;


public class LongestCommonSubsequence{
    public static void main(String[] args) {
        String first="ABCDE";
        String second="CDEFG";
        int result= getMaxCommonSubsequence(first,second, first.length(),second.length());
        System.out.println(result);
    }

    private static int getMaxCommonSubsequence(String first, String second, int m, int n) {
        if(m==0 || n==0)
            return 0;
        if(first.charAt(m-1)==second.charAt(n-1))
            return 1+getMaxCommonSubsequence(first, second, m-1, n-1);
        return Math.max(getMaxCommonSubsequence(first, second, m, n-1), getMaxCommonSubsequence(first, second, m-1, n));
    }
}