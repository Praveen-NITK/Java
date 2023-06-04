//Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs 
//whereas the other two number occur exactly once and are distinct. 
//You need to find the other two numbers and print them in ascending order.
//https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
package MustDo.Google;

import java.util.HashSet;

public class FindingNumber{
    public static void main(String[] args) {
        int []input={2, 3, 7, 9, 11, 2, 3, 11};//{1,2,3,2,1,4};
        
        //printUniqueNos(input);
        printUniqueNosUsingBits(input);
    }
    

    //Let x and y be the non-repeating elements we are looking for and arr[] be the input array. First, calculate the XOR of all the array elements.
    //xor = arr[0]^arr[1]^arr[2].....arr[n-1]
    //All the bits that are set in xor will be set in one non-repeating element (x or y) 
    //and not in others. So if we take any set bit of xor and divide the elements of the 
    //array in two sets – one set of elements with same bit set and another set with same 
    //bit not set. By doing so, we will get x in one set and y in another set. Now if we 
    //do XOR of all the elements in the first set, we will get the first non-repeating element, 
    //and by doing same in other sets we will get the second non-repeating element.
    private static void printUniqueNosUsingBits(int[] input) {
        int xor=input[0];
        int setBit;
        int firstMissingNum=0;
        int secMissingNumber=0;

        for (int i = 1; i < input.length; i++) {
            xor^=input[i];
        }
        setBit=xor & ~(xor-1);

        for (int i = 0; i < input.length; i++) {
            if((input[i] & setBit)>0){
                firstMissingNum=firstMissingNum^input[i];
            }
            else{
                secMissingNumber=secMissingNumber^input[i];
            }
        }

        System.out.println(firstMissingNum+ " "+secMissingNumber);
    }

    private static void printUniqueNos(int[] input) {
        HashSet<Integer> hset = new HashSet<>();
        //TreeSet<String> hset = new TreeSet<String>(set);
        for (int i = 0; i < input.length; i++) {
            if(!hset.contains(input[i])){
                hset.add(input[i]);
            }
            else{
                hset.remove(input[i]);
            }
        }
        System.out.println(hset);
    }

    //3. we can also use sorting and then check with neighbour --> O(nlogn)
}