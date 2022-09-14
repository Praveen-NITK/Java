package ArrayPrograms;


import java.util.Arrays;
import java.util.Stack;

public class NextLarger {
    public static void main(String[] args) {
        int [] input={1,2,3,4,3};

        System.out.println(Arrays.toString(nextLarge(input)));
    }

    //BruteForce O(n^2)
    private static int[] nextLarge(int[] nums) {
        int arr[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=-1;
            for(int j=1;j<nums.length;j++){
                if(nums[(i+j)%nums.length]>nums[i]){
                    arr[i]=nums[(i+j)%nums.length];
                    break;
                }
            }
        }
        return arr;
    }
//    private static int[]  nextLarge(int[] nums){
//        Stack<Integer> st = new Stack<>();
//        int n = nums.length;
//
//        for(int i =  n-2; i >= 0; i--) {
//            while(!st.isEmpty() && st.peek() <= nums[i]) {
//                st.pop();
//            }
//            st.push(nums[i]);
//        }
//        int ans[] = new int[n];
//        for(int i = n-1; i >= 0; i--) {
//            while(!st.isEmpty() && st.peek() <= nums[i]) {
//                st.pop();
//            }
//            ans[i] = st.size() <= 0 ? -1 : st.peek();
//            st.push(nums[i]);
//        }
//        return ans;
//    }
}
