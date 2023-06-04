package Others;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * two blocks will get merged and will get passed as one block to next positioned block
 * {1,2,1,3,4,5,1} -> {1,0,2,3,4,5,1} -> {1,0,0,4,4,5,1} -> {1,0,0,0,6,5,1} ->{1,0,0,0,0,8,1} ->{1,0,0,0,0,0,5} ->{1,0,0,0,0,0,1,2} ->{1,0,0,0,0,0,1,0,1}
 * so left blocks are 3
 */
public class MergeBlocks {
    public static void main(String[] args) {
//        int []input={4,0,3,0}; //1
//        int []input={4,2,3,0}; //2
//        int []input={4,2,4,0}; //2
//        int []input={1,2,1,3,4,5,1}; //3
        int []input={5}; //2

        int leftOver=mergeAndGetLeftOver(input);
        System.out.println(leftOver);
    }

    private static int mergeAndGetLeftOver(int[] input) {
        int[] inpList= new int[100];
        Arrays.fill(inpList,0);
        for (int i = 0; i < input.length; i++) {
            inpList[i]=input[i];
        }

        int counter=0;
        for (int i = 0; i < 99; i++) {
            counter+=inpList[i]%2;
            inpList[i+1]=inpList[i+1]+inpList[i]/2;
        }
        return counter;
    }
}
