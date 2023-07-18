package org.practice.Recursion;

//https://www.youtube.com/watch?v=xZykmhcWGuY&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=19
public class PrintPermutations {
    public static void permutations(String s, String permutation){
        if(s.length()==0){
            System.out.println(permutation);
            return;
        }
        //a->(bc,a)
        //b->(ac,b)
        //c->(ab,c)
        for (int i = 0; i < s.length(); i++) {
            
            char currentChar=s.charAt(i);
            String newString= s.substring(0,i)+s.substring(i+1);

            permutations(newString,permutation+currentChar);
        }
    }

    public static void main(String[] args) {
        String s= "abc";
        permutations(s,"");
    }
}
