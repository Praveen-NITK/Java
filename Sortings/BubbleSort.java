package Sortings;
public class BubbleSort{
    public static void main(String[] args) {
        Integer[] arr={2,78,454,25,434,45,23,54};
        bubbleSortWithWhile(arr);
        //bubbleSortFor(arr);
        //bubbleSortRecursive(arr, arr.length);        
    }

    private static void bubbleSortWithWhile(Integer[] input) {
        boolean isSwapped;
        do{
            isSwapped=false;
            for(int i=0;i<input.length-1; i++){
                //swap
                if(input[i]>input[i+1]){
                    input[i]=input[i]+input[i+1];
                    input[i+1]=input[i]-input[i+1];
                    input[i]=input[i]-input[i+1];
                    isSwapped=true;
                }
            }
        }while(isSwapped);

        for(Integer value:input){
            System.out.println(value);
        }
    }

    private static void bubbleSortFor(Integer[] input){
        int n=input.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(input[j]>input[j+1]){
                    input[j]=input[j]+input[j+1];
                    input[j+1]=input[j]-input[j+1];
                    input[j]=input[j]-input[j+1];
                }
            }
        }
        for(Integer data:input){
            System.out.println(data);
        }
    }

    private static void bubbleSortRecursive(Integer []arr,int n){
        if(n<=0){
            for(Integer data:arr){
                System.out.println(data);
            }
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        bubbleSortRecursive(arr,n-1);        
    }
}