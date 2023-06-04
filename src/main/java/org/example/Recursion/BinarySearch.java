package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int []input={3,4,5,6,7,8,9};
        int indexRecursive=searchBinary(input,9, 0,input.length-1);
        int indexIterative=binarySearch(input,9, 0,input.length-1);
        System.out.println(indexRecursive);
        System.out.println(indexIterative);
    }

    private static int searchBinary(int[] input, int key, int low, int high) {
        if(low>high)
            return -1;
        int mid= (low+high)/2;
        if(input[mid]==key)
            return mid;
        else if(key<input[mid])
            return searchBinary(input,key,low,mid-1);
        else
            return searchBinary(input,key,mid+1,high);
    }

    private static int binarySearch(int[] input, int key, int low, int high){
        while (low<=high){
            int mid= (low+high)/2;
            if(input[mid]==key)
                return mid;
            else if(key<input[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }


}
