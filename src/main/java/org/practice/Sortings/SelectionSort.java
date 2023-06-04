package Sortings;
public class SelectionSort{
    public static void main(final String[] args) {
        final int[] input={8,4,7,3,1,0,5,6,9,2};
        selctionSort(input);

        //recursiveSelectionSort(input,0);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+ " ");
            
        }
    }

    private static void recursiveSelectionSort(int[] input, int start) {
        for (int i = start+1; i < input.length; i++) {
            if(input[start]>input[i]){
                int temp=input[i];
                input[i]=input[start];
                input[start]=temp;
                recursiveSelectionSort(input, i);
            }
        }
    }

    //Wrong
    private static void selctionSort(int[] input) {
        
        for (int i = 0; i < input.length; i++) {
            int min=input[i];
            for (int j = i+1; j < input.length; j++) {
                    min=Math.min(min, input[i]);
            }
            int temp=input[i];
            input[i]=min;
            //input[j]=temp;
        }        
    }

}