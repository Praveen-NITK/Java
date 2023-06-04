package Others;
public class MaxDifference{
    public static void main(String[] args) {
        int[] input= new int[]{1,5,2,8,10,6};
        int maxDiff= findMaxDifference(input);
        System.out.println("Max Diff is: "+maxDiff);
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
}