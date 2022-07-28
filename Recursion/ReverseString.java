package Recursion;

public class ReverseString {
    public static void main(String[] args) {
        String original="s";
        String reversed=reverse(original,original.length() );
        System.out.println(reversed);
    }

    //O(n)
    private static String reverse(String s, int n) {
        if(n==0)
            return s;
        return s.substring(n-1)+reverse(s.substring(0,n-1),n-1);
    }
}
