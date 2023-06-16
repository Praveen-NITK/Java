package org.practice.DP;
public class WordInterleave{
    public static void main(String[] args) {
        String A="abcd";
        String B="xyz";
        String C="axbcyzd";

        boolean isInterleaved=isWordsInterleaved(A,B,C);        
        System.out.println("C is interleaved of A and B: "+isInterleaved);

    }

    private static boolean isWordsInterleaved(String a, String b, String c) {
        if(c.length()!=a.length()+b.length())
            return false;
        if(c.isEmpty() && b.isEmpty()&& a.isEmpty())
            return true;
        if(c.isEmpty() && (!b.isEmpty() || !a.isEmpty()))
            return false;
        if(a.length()>0 && c.length()>0 && a.charAt(0)==c.charAt(0))
            return isWordsInterleaved(a.substring(1),b,c.substring(1));
        if(b.length()>0 && c.length()>0 && b.charAt(0)==c.charAt(0))
            return isWordsInterleaved(a,b.substring(1),c.substring(1));
        return false;
    }
}
