package Searchings;
public class  RotatedBS 
{ 
	public static void main(String args[]) 
	{ 
	int arr1[] = {5, 6, 7, 7, 8, 9, 10, 1, 2, 2, 3, 3}; 
	int key = 9;
	System.out.println("Index of the element is : "
					+ rotatedBS(arr1, key)); 
	} 

	private static int binarySearchWithArray(int[] input, int value, int start, int last) {
        if(last<start){
            return -1;
        }
        int mid= (start+last)%2==0?(start+last)/2-1:(start+last)/2;
        if(value==input[mid]){
            return mid;
        }
        if(value<input[mid])
            return binarySearchWithArray(input, value, start,mid-1);
        return binarySearchWithArray(input, value, mid+1, last);        
    }

    private static int rotatedBS(int[] input, int number){
        int pivot=findPivot(input,0,input.length-1);
        if(input[pivot]==number){
            return pivot;
        }
        if(number>input[input.length-1]){
            return binarySearchWithArray(input, number, 0, pivot);
        }
        return binarySearchWithArray(input, number, pivot+1, input.length);
    }

    private static int findPivot(int[] input,int start, int end) {   
        if(end<start){
            return -1;
        }  
        if(end==start){
            return start;
        }   
        int mid= (start+end)/2;
        if(input[mid]<input[mid-1]||input[mid]>input[mid+1]){
            return mid;
        }
        if(input[mid]>input[end]){
            return findPivot(input,mid+1,end);
        }
        return findPivot(input, start, mid-1);
    }
	

} 
