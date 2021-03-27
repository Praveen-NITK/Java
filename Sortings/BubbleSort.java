package Sortings;

import java.util.Arrays;

public class BubbleSort{
    public static void main(String[] args) {
        int[] arr={2,78,45,454,25,434,45,23,54};
//        bubbleSortWithWhile(arr);
//        bubbleSortFor(arr);
        bubbleSortRecursive(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    private static void bubbleSortWithWhile(int[] input) {
        boolean isSorted;
        do{
            isSorted=true;
            for(int i=1;i<input.length; i++){
                //swap
                if(input[i-1]>input[i]){
                    swap(input, i);
                    isSorted=false;
                }
            }
        }while(!isSorted);

    }

    private static void bubbleSortFor(int[] input){
        for(int i=0;i<input.length;i++){
            boolean isSorted=true;
            for(int j=1;j<input.length;j++){
                if(input[j-1]>input[j]){
                    input=swap(input, j);
                    isSorted=false;
                }
            }
            if (isSorted)
                return;
        }
    }

    private static int[] swap(int[] input, int j) {
        int temp=input[j];
        input[j]=input[j-1];
        input[j-1]=temp;
        return input;
    }

    private static void bubbleSortRecursive(int []arr,int n){
        if(n<=0)
            return;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                swap(arr, i);
            }
        }
        bubbleSortRecursive(arr,n-1);        
    }
}