package JavaConcepts;

import java.util.Arrays;
import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        int data[]= new int[10];
        Random rand= new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i <data.length ; i++) {
            data[i]=rand.nextInt(100);
        }
        int[] orig= Arrays.copyOf(data,data.length);
        System.out.println(Arrays.toString(orig));
        insertionSort(data);
        System.out.println(Arrays.toString(data));

    }
    private static void insertionSort(int[] input){
        for (int i = 1; i <input.length ; i++) {
            int key= input[i];
            int j=i;
            while(j>0 && input[j-1]>key){
                input[j]=input[j-1];
                j--;
            }
            input[j]=key;
        }
    }
}
