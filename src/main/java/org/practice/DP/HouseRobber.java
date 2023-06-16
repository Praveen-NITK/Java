package org.practice.DP;

public class HouseRobber {
    public static void main(String[] args) {
        int []input={2,7,9,3,1};
        int maxMoney=calculateMaxMoney(input,0);
        System.out.println(maxMoney);
    }

    private static int calculateMaxMoney(int[] input, int start) {
        if(start>=input.length)
            return 0;
        //2 choices not rob, rob
        return Math.max(calculateMaxMoney(input,start+1), //Not rob
                input[start]+calculateMaxMoney(input,start+2)); //Rob
    }
}
