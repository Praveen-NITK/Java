package ArrayPrograms;

import java.util.Arrays;
import java.util.Random;

public class ReverseArray {
    public static void main(String[] args) {
        Random rand = new Random();
        int []input=new int[10];
        for (int i = 0; i <10 ; i++) {
            input[i]=rand.nextInt(50);
        }
        System.out.println(Arrays.toString(input));
        reverseArrayRecursive(input,0,input.length-1);
        System.out.println(Arrays.toString(input));
        reverseArray(input,0,input.length-1);
        System.out.println(Arrays.toString(input));

    }

    private static void reverseArray(int[] input, int low, int high) {
        while(low<high && high<input.length && low>=0){
            int temp=input[low];
            input[low++]=input[high];
            input[high--]=temp;
        }
    }
    private static void reverseArrayRecursive(int[] input, int low, int high) {
        if(low<high){
            int temp=input[low];
            input[low]=input[high];
            input[high]=temp;

            reverseArrayRecursive(input,low+1,high-1);
        }
    }
}
