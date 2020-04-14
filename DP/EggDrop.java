//https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
package DP;
public class EggDrop{
    public static void main(String[] args) {
        int minNoOfTrials=getMinNoOfTrials(2,10);
        System.out.println(minNoOfTrials);
    }

    private static int getMinNoOfTrials(int eggs, int floors) {
        if(eggs==1){
            return floors;
        }
        if(floors==1 || floors==0){
            return floors;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < floors; i++) {       
            //At any time at floor i 
            //if egg breaks-->remaining no of floors to compute=i-1 with e-1 
            //else if egg not breaks --> remaining no of floors to compute is n-i with e eggs

            min= Math.min(min, Math.max(getMinNoOfTrials(eggs-1,i-1), 
                                                    getMinNoOfTrials(eggs,floors-i)+1));
        }
        return min;
    }
}