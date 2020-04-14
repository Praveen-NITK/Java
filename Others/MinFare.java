package Others;
import java.util.Arrays;

public class MinFare{
    public static void main(String[] args) {
        int [][]cost=new int[][]{{0,10,75,94},
                                {-1,0,35,50},
                                {-1,-1,0,10},
                                {-1,-1,-1,0}};

        int [][]cache=new int[4][4];

        //Arrays.fill(cache, 0);

        int src=0;
        int dest=3;
        //int fare=getMinFareRecursive(cost,src,dest,cache);
        int fare=getMinFareDP(src,dest);
        System.out.println("Minimum fare between "+src+" and "+dest+" is: "+fare);
    }

    private static int getMinFareRecursive(int[][] cost, int src, int dest, int [][]cache) {
        if(src==dest || src==dest-1){
            return cost[src][dest];
        }
        if(cache[src][dest]==0){
            int minFare=cost[src][dest];
            for(int i=src+1;i<dest;i++){
                int temp=getMinFareRecursive(cost,src,i,cache)+getMinFareRecursive(cost, i, dest,cache);
                if(temp<minFare){
                    minFare=temp;
                }
                cache[src][dest]= minFare;
            }
        }
        return cache[src][dest];
    }

    private static int getMinFareDP(int src, int dest){
        int []minCost={0};
        if(src==dest || src==dest-1){
            
        }
        return 0;
    }
}