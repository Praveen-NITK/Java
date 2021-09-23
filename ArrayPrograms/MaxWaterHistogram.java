//https://www.geeksforgeeks.org/trapping-rain-water/
package ArrayPrograms;
public class MaxWaterHistogram{
    public static void main(String[] args) {
        int input[] = {4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 4};
        System.out.println(maxWater(input));
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

    //O(n)
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
}