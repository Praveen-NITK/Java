package Searchings;
//https://www.geeksforgeeks.org/find-element-bitonic-array/
public class BitonicArraySearch{
    public static void main(String[] args) {
        int[] input={-1,4,6,11,16,20,21,17,8,3,1};
        int index=searchInBitonicArray(input,17);
        System.out.println("Element is present at : "+index);
    }

    private static int searchInBitonicArray(int[] input, int key){
        int pivot=getPivot(input, 0, input.length);
        if(key==input[pivot])
            return pivot;

        int result=BinarySearch(input,0,pivot, key,true);
        
        if(result==-1)
            return BinarySearch(input,pivot+1, input.length, key, false);
        return result;
    }

    private static int BinarySearch(int[] input, int start, int end, int key, boolean isAscending) {
        if(start>end)
            return -1;
        if(start==end)
            return -1;
        int mid=(start+end)/2;
        if(input[mid]==key)
            return mid;
        if(input[mid]<key || isAscending)
            return BinarySearch(input, start, mid, key,isAscending);
        return BinarySearch(input, mid+1, end, key,isAscending);
    }

    private static int getPivot(int[] input, int start, int end) {
        if(end<start)
            return -1;
        if(end==start)
            return start;
        int mid=(start+end)/2;
        if(input[mid]>input[mid-1] && input[mid]>input[mid+1]){
            return mid;
        }
        if(input[mid]>input[mid-1] && input[mid]<input[mid+1])
            return getPivot(input, mid+1, end);
        return getPivot(input, start, mid);
    }
}