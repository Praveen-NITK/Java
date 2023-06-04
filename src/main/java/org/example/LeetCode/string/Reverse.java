package LeetCode.string;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        String s ="test";
        System.out.println("before reverse: "+s);
        String result =reverseRecursive(0, s.toCharArray());
        System.out.println("after reverse: "+result);
    }

    private static String reverseRecursive(int startIndex,char[] s) {
        if(startIndex>=s.length/2)
            return Arrays.toString(s);
        swapChar(s,startIndex);
        return reverseRecursive(startIndex+1,s).toString();
    }

    private static void swapChar(char[] s, int startIndex) {
        char temp=s[startIndex];
        s[startIndex]=s[s.length-1-startIndex];
        s[s.length-1-startIndex]=temp;
    }
}
