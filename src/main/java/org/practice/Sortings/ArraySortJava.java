package Sortings;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class ArraySortJava {
    public static void main(String[] args) {
        Integer []input={3,5,2,6,1,4};
        ascendingOrder(input);
        System.out.println(Arrays.toString(input));
        descendingOrder(input);
        System.out.println(Arrays.toString(input));
    }

    private static void ascendingOrder(Integer[] input) {
        Arrays.sort(input);
    }

    private static void descendingOrder(Integer[] input) {
//        Arrays.sort(input, Collections.reverseOrder());

        //Other way
        ascendingOrder(input);
        // then reverse
        for (int i = 0; i <input.length/2 ; i++) {
            int temp=input[input.length-i-1];
            input[input.length-i-1]=input[i];
            input[i]=temp;
        }
        
    }

}
