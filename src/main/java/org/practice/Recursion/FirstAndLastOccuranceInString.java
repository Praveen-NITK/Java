package org.practice.Recursion;

public class FirstAndLastOccuranceInString {
    public static int first=-1;
    public static int last=-1;

    public static void main(String[] args) {
        String s= "bccsbega";
        findOccurance('a',s,0,s.length()-1);
        System.out.println(first+" and "+last);
    }

    private static void findOccurance(char c, String s, int left, int right) {
        if(left>=s.length())
            return;
        if(first==-1 && s.charAt(left)==c)
            first=left;
        if(last==-1 && s.charAt(right)==c)
            last=right;
        findOccurance(c, s,left+1, right-1);
    }
}
