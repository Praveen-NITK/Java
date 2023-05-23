package AlgorithmsBook;

/**
 * Fill the m litre jug and empty it into n liter jug.
 * Whenever the m liter jug becomes empty fill it.
 * Whenever the n liter jug becomes full empty it.
 * Repeat steps 1,2,3 till either n liter jug or the m liter jug contains d litres of water.
 */
public class WaterBucket {
    public static void main(String[] args) {
        waterBucketSteps(3,5,4);
    }

    //https://www.geeksforgeeks.org/two-water-jug-puzzle/
    private static void waterBucketSteps(int firstCap, int secondCap, int target) {
        int from = firstCap;
        int to =0;
        while(from!=target && to!=target){

            System.out.println(from+ " "+ to);

            int pourWater= Math.min(from,secondCap-to);
            from-=pourWater;
            to+=pourWater;

            System.out.println(from+ " "+ to);
//          if(from==target || to==target)
//              break;
            if(from==0)
                from=firstCap;
            if(to==secondCap)
                to=0;
        }
    }

}
