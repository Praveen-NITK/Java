package org.practice.streamDemo;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        String [][]arr= new String[][]{{"1","2","3"}, {"4","5","6"}};
        String flatten[]= Stream.of(arr).flatMap(x->Stream.of(x)).toArray(String[]::new);
        Arrays.stream(flatten).forEach(x->System.out.println(x));
    }
}
