package org.practice.Others;

/**
 * input [8,8,8,5,5]
 * possible encoding [3,8,2,5] , [3,8,0,9,2,5], [1,8,2,8,0,9,2,5]
 * next(2) ->8
 * next(3) ->5
 * next(1) -> -1
 */
public class RunLengthEncoding {
    static int []input;
    public RunLengthEncoding(int []arr){
        this.input=arr;
    }
    int result=-1;
    int currentPos=0;
    int lastNoOfTimes=0;
    int iterator=0;

    //Skips n element and return last skipped
    public int next(int n){
        currentPos+=n;

        while (currentPos<input.length && iterator<input.length){
            int noOfTimes = input[iterator];
            int positiveNumber = input[iterator + 1];

            if(noOfTimes==0){
                iterator+=2;
                continue;
            }
            if (n <= noOfTimes) {
                iterator+=2;
                return positiveNumber;
            }
            else{
                n=n-noOfTimes;
            }
            iterator+=2;
        }

        return result;
    }

    public static void main(String[] args) {
        RunLengthEncoding rle=new RunLengthEncoding(new int[]{3,8,0,9,2,5});
        System.out.println(rle.next(2));
        System.out.println(rle.next(3));
        System.out.println(rle.next(2));
        System.out.println(rle.next(1));
        System.out.println(rle.next(1));
    }
}
