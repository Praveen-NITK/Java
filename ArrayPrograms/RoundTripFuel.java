package ArrayPrograms;

public class RoundTripFuel {
    public static void main(String[] args) {
        int []fuel={1,2,3,4,5};
        int []cost={5,4,2,5,1};


        System.out.println(canCompleteCircuit(fuel,cost));
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
}
