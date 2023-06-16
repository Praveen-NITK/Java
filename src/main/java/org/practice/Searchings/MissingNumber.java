package org.practice.Searchings;
//Numbers are sorted in range 1 to n+1, all unique one is missing
//E.g {1,2,3,5,6,7,8}   --> missing number=4
public class MissingNumber{
    public static void main(String[] args) {
        int []input= {1,2,3,4,5,7,8};
        int missedNumber= findMissing(input);
        System.out.println("Missing number is : "+missedNumber);
    }

    private static int findMissing(int[] input) {
        int l=0;
        int h=input.length;
        int mid=0;

        while(l<=h){
            mid= (l+h)/2; 
            //If mid-1>0 and mid+1<length check is required for edge cases.
            if(input[mid]!=mid+1 && (input[mid-1]==mid || input[mid+1]==mid+1)){
                return mid+1;
            }           
            if(input[mid]==mid+1){
                l=mid+1;
            }
            else {
                h=mid-1;
            }            
        }
        return -1;
    }
}
