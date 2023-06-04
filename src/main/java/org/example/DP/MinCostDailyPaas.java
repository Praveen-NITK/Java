package DP;
public class MinCostDailyPaas{
    public static void main(String[] args) {
        int []TravelDays=new int[]{1,2,25,6,9,28,29};
        int minCost=calCulateMinPassCost(TravelDays);
        System.out.println("Minimum cost occured will be: "+minCost);
    }
    private static int calCulateMinPassCost(int[] travelDays){
        //int minPassCost=0;
        boolean []dayVisited=new boolean[31];

        for (int day : travelDays) {
            dayVisited[day]=true;
        }

        int []minCostTillDate=new int[31];

        minCostTillDate[0]=0;

        for (int d = 1; d < 31; d++) {
            if(!dayVisited[d]){
                minCostTillDate[d]=minCostTillDate[d-1];
                continue;
            }
            int minCost=0;

            //1 Day paas 2 rs.
            minCost=minCostTillDate[d-1]+2;

            //7 days paas 7 rs.
            minCost=Math.min(minCost, minCostTillDate[Math.max(0,d-7)]+7);

            //30 day paas 25 rs.
            minCost=Math.min(minCost, minCostTillDate[Math.max(0, d-30)]+25);

            minCostTillDate[d]=minCost;
        }

        return minCostTillDate[30];
    }
}
