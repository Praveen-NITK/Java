package ArrayPrograms;


import java.util.Arrays;
import java.util.Stack;

public class NextLarger {
    //element greater than them present on the right side circular
    public static void main(String[] args) {
        int [] input={1,0,3,5,4};
//        int [] input={13,7,6,12};

        System.out.println(Arrays.toString(nextLargeCircular(input)));
        System.out.println(Arrays.toString(nextLarge(input)));
    }

    //BruteForce O(n^2)
    //element greater than them present on the right side
    private static int[] nextLarge(int[] input) {
        int output[] = new int[input.length];
        for(int i = 0; i< input.length; i++){
            output[i]=-1;
            for(int j = 1; j< input.length-i; j++){
                if(input[i+j] > input[i]){
                    output[i]= input[i+j];
                    break;
                }
            }
        }
        return output;
    }

    //element greater than them present on the right side circular
    private static int[] nextLargeCircular(int[] input) {
        int output[] = new int[input.length];
        for(int i = 0; i< input.length; i++){
            output[i]=-1;
            for(int j = 1; j< input.length; j++){
                if(input[(i+j)%input.length] > input[i]){
                    output[i]= input[(i+j)%input.length];
                    break;
                }
            }
        }
        return output;
    }

    private static int[]  nextLargeS(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for(int i =  n-2; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            st.push(nums[i]);
        }
        int ans[] = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            ans[i] = st.size() <= 0 ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
}
