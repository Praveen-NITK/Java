//https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
package org.practice.Strings;

import java.util.Arrays;
import java.util.Comparator;

public class SortString{
    public static void main(String[] args) {
        String input="iloveyou";
        //String output=stringSortUtil(input);
        String output= stringSortUtils(input);
        System.out.println("Input: "+input);
        System.out.println("Output: "+output);
        System.out.println(input.compareTo(output));
    }

    //Using natural sorting method
    private static String stringSortUtil(String input) {
        char toSort[]=input.toCharArray();
        Arrays.sort(toSort);

        return new String(toSort);
    }

    //Using 
    private static String stringSortUtils(String input){
        Character []toSort= new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            toSort[i]=input.charAt(i);
        }

        Arrays.sort(toSort,new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2){
                return Character.compare(Character.toLowerCase(c1),Character.toLowerCase(c2));
            }
        });

        StringBuilder sb = new StringBuilder(toSort.length);
        for (Character character : toSort) {
            sb.append(character);
        }
        return sb.toString();
    }
}