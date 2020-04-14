package Searchings;
import java.util.*;

public class BinarySearch{
    public static void main(String[] args) {
        Integer [] input= new Integer[]{1,6,8,9,9,13}; 
        int key=7;
        System.out.println("Index of element is: "+binarySearchWithArray(input, key,0,input.length-1));

        System.out.println("Index of element is: "+iterativeBinarySearch(input, key));

        List<Integer> inputList= new ArrayList<>();
        inputList.addAll(Arrays.asList(input));
        //With non rotated Array
        //boolean isExist= binarySearchWithList(inputList, key);
        //System.out.println("Element "+key+" Exist? "+isExist);
    }

    private static int iterativeBinarySearch(Integer[] input, int key){
        int l=0, r=input.length-1;

        while(l<=r){
            int m= l+(r-l)/2;
            if(input[m]==key)
                return m;
            if(input[m]<key)
                l=m+1;
            else
                r=m-1;            
        }
        return -1;
    }

    private static boolean binarySearchWithList(List<Integer> inputList, int toFind) {
        if(inputList.size()<1){
            return false;
        }
        int mid= inputList.size()/2;
        if(toFind==inputList.get(mid)){
            return true;
        }
        if(toFind<inputList.get(mid)){
            return binarySearchWithList(inputList.subList(0, mid), toFind);
        }
        if(toFind>inputList.get(mid)){
            return binarySearchWithList(inputList.subList(mid+1, inputList.size()), toFind);
        }
        return false;
    }

    private static int binarySearchWithArray(Integer[] input, int value, int start, int last) {
        if(last<start){
            return -1;
        }        
        int mid= start+(last-start)/2;
        if(value==input[mid]){
            return mid;
        }
        if(value<input[mid])
            return binarySearchWithArray(input, value, start,mid-1);
        return binarySearchWithArray(input, value, mid+1, last); 
    }
    
}