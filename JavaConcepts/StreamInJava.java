//https://www.geeksforgeeks.org/stream-in-java/
package JavaConcepts;

import java.util.Arrays;

public class StreamInJava {
    public static void main(String[] args) {
        int []input= new int[]{1,2,3,4,5,6};
//        addFive(input);
        sqaureAndAddFive(input);
    }

    private static void addFive(int[] input) {
        Arrays.stream(input).forEach(x-> System.out.println(x+5));
    }
    private static void sqaureAndAddFive(int[] input){
        Arrays.stream(input).map(x->sqaure(x)).forEach(y-> System.out.println(y+5));
//        Arrays.asList(input).stream().map(x->x*x).forEach(y-> System.out.println(y));
    }

    private static int sqaure(int x) {
        return x*x;
    }
}