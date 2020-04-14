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
}