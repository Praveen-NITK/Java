package org.practice.ArrayPrograms;

public class RoundTripFuel {
    public static void main(String[] args) {
        int []fuel={0,2,3,4,5};
        int []cost={4,2,2,5,1};

        //Get the starting index where it can start to complete all stations
        System.out.println(canCompleteCircuit(fuel,cost));
        System.out.println(startIndex(fuel,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        //total surplus during the whole journey
        int total  = 0;

        // our tank
        int gasAvailable = 0;

        int index = 0;

        for(int i = 0; i < n; i++){
            total  += gas[i] - cost[i];
            gasAvailable += gas[i] - cost[i];

            // if the tank goes -ve
            if(gasAvailable < 0){
                gasAvailable = 0;
                index = i + 1;
            }
        }

        return (total  < 0) ? -1 : index;
    }

    private static int startIndex(int[] gas, int[] cost){
        int total=0;
        int n=gas.length;
        int index=0;
        int gasAvailable=0;
        for (int i = 0; i < n; i++) {

            total += gas[i] - cost[i];
            gasAvailable += gas[i] - cost[i];

            if (gasAvailable < 0) {
                gasAvailable = 0;
                index = i + 1;
            }
        }
        return (total<0)? -1: index;
    }

}
