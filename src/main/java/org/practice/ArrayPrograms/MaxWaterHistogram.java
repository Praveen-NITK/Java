//https://www.geeksforgeeks.org/trapping-rain-water/
package org.practice.ArrayPrograms;
public class MaxWaterHistogram{
    public static void main(String[] args) {
        int input[] = {4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 4,1};
//        int input[] = {4, 1, 0, 2, 1, 0, 1, 3};
        //int input[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxWater(input));
        System.out.println(OptimizedMaxWater(input));
        System.out.println(trap(input));
        System.out.println(waterStore(input));
    }

    //O(n^2)
    private static int maxWater(int[] input) {
        int result=0;
        for (int i = 1; i < input.length-1; i++) {
            int left_Max=input[i];
            for (int j = 0; j < i; j++) {
                left_Max=Math.max(left_Max, input[j]);
            }

            int right_Max=input[i];
            for (int j = i+1; j < input.length; j++) {
                right_Max=Math.max(right_Max, input[j]);
            }

            result+=Math.min(left_Max, right_Max)-input[i];
        }
        return result;
    }

    //O(n) - used memoize
    private static int OptimizedMaxWater(int[] input) {
        int result=0;
        int []left_max = new int[input.length];
        int []right_max = new int[input.length];

        left_max[0]=input[0];
        for (int i =1; i < input.length; i++) {
            left_max[i]=Math.max(left_max[i-1],input[i]);
        }

        right_max[input.length-1]=input[input.length-1];
        for (int i =input.length-2; i >=0; i--) {
            right_max[i]=Math.max(right_max[i+1],input[i]);
        }

        for (int i = 0; i < input.length; i++) {
            result=result+Math.min(left_max[i],right_max[i])-input[i];
        }
        return result;
    }

    //https://labuladong.gitbook.io/algo-en/iv.-high-frequency-interview-problem/trapping_rain_water
    private static int trap(int[] input) {
        if (input.length==0) return 0;

        int left = 0, right = input.length - 1;
        int ans = 0;

        int l_max = input[left];
        int r_max = input[right];

        while (left <= right) {
            l_max = Math.max(l_max, input[left]);
            r_max = Math.max(r_max, input[right]);

            // ans += min(l_max, r_max) - input[i]
            if (l_max < r_max) {
                ans += l_max - input[left];
                left++;
            } else {
                ans += r_max - input[right];
                right--;
            }
        }
        return ans;
    }

    private static int waterStore(int[] input){
        int N = input.length - 1;

        int leftMax=input[0];
        int rightMax=input[N];

        int maxWater=0;

        for (int i = 1; i < N; i++) {
            if(leftMax<input[i])
                leftMax=input[i];

            if(rightMax<input[N-i])
                rightMax=input[N-i];

            maxWater+=Math.min(leftMax,rightMax)-input[i];

        }
        return maxWater;
    }
}