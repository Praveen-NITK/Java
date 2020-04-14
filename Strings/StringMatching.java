package Strings;
//Karumanchi--DS & A Made Eaasy - pg 324
//Q. Search for the first occurance of a pattern string P in a text string T
public class StringMatching{
    public static void main(String[] args) {
        String P="abc";
        String T="tabkdaabc";
        int matchIndex=findMatchIndex(P,T);
        System.out.println(matchIndex);
        
    }

    private static int findMatchIndex(String p, String t) {
        for (int i = 0; i <= t.length()-p.length(); i++) {
            int j=0;
            while(j<p.length() && p.charAt(j)==t.charAt(i+j)){
                j=j+1;
            }
            if(j==p.length())
                return i;
        }
        return -1;
    }
}