package org.practice.streamDemo;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://mkyong.com/tutorials/java-8-tutorials/
public class JoinArray {
    public static void main(String[] args) {
        int []arr1={1,2,3};
        int []arr2={4,5,6};
        int []arr3={7,8,9};

        int []result= IntStream.concat(Arrays.stream(arr1),IntStream.concat(Arrays.stream(arr2),Arrays.stream(arr3))).toArray();
        System.out.println(Arrays.toString(result));

        String []inp1={"a","b","c"};
        String []inp2={"d","e"};
        String []inp3={"f"};
        String[] mergedArray= Stream.of(inp1,inp2,inp3).flatMap(Stream::of).toArray(String[]::new);
        System.out.println(Arrays.toString(mergedArray));
    }
}
