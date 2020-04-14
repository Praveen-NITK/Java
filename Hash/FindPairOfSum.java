package Hash;
import java.util.Hashtable;

//https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/

public class FindPairOfSum{
    public static void main(String[] args) {
        int []arr= new int[]{2,1,6,7,10};
        boolean ispairExists= isPairOfSumExists(arr,10);
        System.out.println(ispairExists);
    }

    private static boolean isPairOfSumExists(int[] arr, int sum) {
        Hashtable<Integer,Boolean> hashtable= new Hashtable<>();
        for (Integer var : arr) {
            hashtable.put(var, true);
        }
        for(int i=0;i<arr.length;i++){
            if(hashtable.containsKey(sum-arr[i])){
                return true;
            }
        }
        return false;
    }
}