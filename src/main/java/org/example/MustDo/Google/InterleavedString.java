//https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33
package MustDo.Google;
public class InterleavedString{
    public static void main(String[] args) {
        String a="aab";//"TTO";
        String b= "axy";//"OMA";
        String c= "aaxaby";//"TOMATO";
        boolean isInterleaved=isInteleavedRecursive(a,b,c);
        boolean isInterleavedDP=isInteleavedDP(a,b,c);
        
        System.out.println("String is interleaved: "+isInterleaved);
        System.out.println("String is interleaved DP: "+isInterleavedDP);

    }

    private static boolean isInteleavedRecursive(String a, String b, String c) {
        if(a.isEmpty()&& b.isEmpty() && c.isEmpty()){
            return true;
        }
        if(c.isEmpty())
            return false;
        return ((!a.isEmpty() && c.charAt(0)==a.charAt(0)) && 
        isInteleavedRecursive(a.substring(1), b, c.substring(1)) ||
        (!b.isEmpty() &&c.charAt(0)==b.charAt(0)) && 
        isInteleavedRecursive(a, b.substring(1), c.substring(1)));
    }

    private static boolean isInteleavedDP(String a, String b, String c) {
        if(a.isEmpty()&& b.isEmpty()){
            return c.isEmpty();
        }
        if(a.isEmpty())
            return b.equals(c);
        if(b.isEmpty())
            return a.isEmpty();
        if(a.length()+b.length()!=c.length())
            return false;
        
        boolean [][]DP= new boolean[a.length()+1][b.length()+1];
        DP[0][0]=true;
        
        for (int i = 1; i <= a.length(); i++) {
            DP[i][0]=DP[i-1][0] && c.charAt(i-1)==a.charAt(i-1);
        }

        for (int j = 1; j <= a.length(); j++) {
            DP[0][j]=DP[0][j-1] && c.charAt(j-1)==b.charAt(j-1);
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                DP[i][j]=(DP[i][j-1] && (c.charAt(i+j-1)==b.charAt(j-1))) ||
                            (DP[i-1][j] && (c.charAt(i+j-1)==a.charAt(i-1)));
            }
        }
        return DP[a.length()][b.length()];
    }
}