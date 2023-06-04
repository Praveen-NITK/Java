package Strings;

/**
 * Its also called as pattern matching algorithm
 */
public class FirstOccurance {
    public static void main(String[] args) {
        String large= "yellowish red is red";
        String small= "red";
        int pos=findIndexofFirstOccurace(large,small);
        System.out.println("First Occurance of small string in large string is: "+pos);
    }

    private static int findIndexofFirstOccurace(String large, String small) {
        for (int i = 0; i <=large.length()-small.length() ; i++) {
            int j=0;
            while(j<small.length() && small.charAt(j)==large.charAt(i+j))
                j=j+1;
            if(j==small.length())
                return i;
        }
        return -1;
    }
}
