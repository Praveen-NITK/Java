//https://www.geeksforgeeks.org/find-smallest-range-containing-elements-from-k-lists/
//Flipkart

package DP;
public class SmallestRange{
    public static void main(String[] args) {
        int k=3;
        int []arr1= {4,7,9,12,15};
        int []arr2= {0,8,10,14,20};
        int []arr3= {6,12,16,30,50};

        printMaxRange(arr1,arr2,arr3);
    }

    //BruteForce
    private static void printMaxRange(int[] arr1, int[] arr2, int[] arr3) {
        int a=-1,b=-1,c=-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int min_sub=Math.min(arr1[i], arr2[j]);
                int max_sub= Math.max(arr1[i], arr2[j]);
                for (int k = 0; k < arr3.length; k++) {
                    min_sub=Math.min(min_sub, arr3[k]);
                    max_sub=Math.max(max_sub, arr3[k]);
                    int diff=max_sub-min_sub;
                    if(diff<min){
                        min=diff;
                        a=arr1[i];
                        b=arr2[j];
                        c=arr3[k];
                    }
                }
            }            
        }
        System.out.println(a+" "+b+" "+c);
    }
}