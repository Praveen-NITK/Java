package Sortings;
public class HeapSort{

    public static void sort(int arr[]){
        int n= arr.length;

        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }

        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr, i, 0);
        }
    }

    //Arguments- arr --> base add of array, 
    //n --> number of elements participating in heapification, 
    //i --> position at which to heapify
    private static void heapify(int[] arr, int n, int i) {
        int largest=i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[largest]<arr[left]){
            largest=left;
        }
        if(right<n && arr[largest]<arr[right]){
            largest=right;
        }
        if(largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int arr[]={2,12,11,13,5,6,7};       
        
        sort(arr);

        for( int item:arr){
            System.out.println(item);
        }
    }
}