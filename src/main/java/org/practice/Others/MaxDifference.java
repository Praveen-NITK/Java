package org.practice.Others;
public class MaxDifference{
    public static void main(String[] args) {
        int[] input= new int[]{7,5,2,4,3,1};
        int maxDiff= findMaxDifference(input);
        int maxDiffAbs= absMaxDifference(input);
        System.out.println("Max Diff is: "+maxDiff);
        System.out.println("Max Diff maxDiffAbs is: "+maxDiffAbs);
    }

    private static int findMaxDifference(int[] input) {
        int min=input[0];
        int maxDiff=0;
        for (int i = 1; i < input.length; i++) {
            if(min>input[i]){
                min=input[i];                
            }
            if(maxDiff<Math.abs(input[i]-min)){
                maxDiff=Math.abs(input[i]-min);
            }           
            
        }
        return maxDiff;
    }
    private static int absMaxDifference(int[] input){
        int min=input[0];
        int max=input[0];
        for (int i = 1; i < input.length; i++) {
            min=Math.min(min,input[i]);
            max=Math.max(max,input[i]);
        }

        return max-min;

    }
}
