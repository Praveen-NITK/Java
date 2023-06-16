//https://www.geeksforgeeks.org/stream-in-java/
package org.practice.JavaConcepts;

import java.util.Arrays;

public class StreamInJava {
    public static void main(String[] args) {
        int []input= new int[]{1,2,7,4,5,8};
//        addFive(input);
//        sqaureAndAddFive(input);
        reduce(input);
    }

    private static void addFive(int[] input) {
        Arrays.stream(input).forEach(x-> System.out.println(x+5));
    }
    private static void sqaureAndAddFive(int[] input){
        Arrays.stream(input).map(x->sqaure(x)).forEach(y-> System.out.println(y+5));
//        Arrays.asList(input).stream().map(x->x*x).forEach(y-> System.out.println(y));
    }
    private static void reduce(int[] input){
        int even= Arrays.stream(input).filter(x->x%2==0).reduce(0,(a, b) ->  b/a);
        System.out.println(even);
    }
//    private static void findMaxByAge{
//        Person minByAge = people
//                .stream()
//                .min(Comparator.comparing(Person::getAge))
//                .orElseThrow(NoSuchElementException::new);
//
//        assertEquals("Should be Alex", alex, minByAge);
//    }

    private static int sqaure(int x) {
        return x*x;
    }
}