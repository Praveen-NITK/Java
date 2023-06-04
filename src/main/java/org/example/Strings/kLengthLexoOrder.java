package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kLengthLexoOrder {
    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometavajocm",3));
    }
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        List<String> kLengthSubs= new ArrayList<>();
        for(int i=0;i<=s.length();i++) {
            for (int j=i+1; j<=s.length(); j++) {
                if(s.substring(i, j).length()==k)
                    kLengthSubs.add(s.substring(i, j));
            }
        }

        Arrays.sort(kLengthSubs.toArray());
        smallest=kLengthSubs.get(0);
        largest=kLengthSubs.get(kLengthSubs.size()-1);
        return largest + "\n" + smallest;

//        List<String> sortedString= new ArrayList<>();
//        for(int i=0; i<= s.length()-k; i++) {
//            sortedString.add(s.substring(i, i+k));
//        }
//        smallest = sortedString.get(0);
//        largest = sortedString.get(sortedString.size()-1);
//        return largest + "\n" + smallest;
    }
}
