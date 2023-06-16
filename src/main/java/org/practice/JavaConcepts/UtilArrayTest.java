package org.practice.JavaConcepts;

import java.util.Arrays;

public class UtilArrayTest {
    public static void main(String[] args) {
//        int []input={3,4,1,2,5};
        int []input={1,3,4,5,6};
        int index=Arrays.binarySearch(input,3);
        System.out.println(index);
    }
}
