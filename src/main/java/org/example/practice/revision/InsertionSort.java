package practice.revision;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int []input={5,2,7,4,9,34,12,3};
        sortUsingInsertionSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }
        System.out.println("0090");
//        Arrays.sort(input);
        System.out.println(Arrays.binarySearch(input,7));
    }

    private static void sortUsingInsertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int data=input[i];
            int j=i;
            while(j>0 && input[j-1]>data){
                input[j]=input[j-1];
                j--;
            }
            input[j]=data;
        }
    }
}
