package DP;
//https://www.geeksforgeeks.org/fractional-knapsack-problem/
import java.util.Arrays;
import java.util.Comparator;

public class  KnapsackFractional{
    public static void main(String[] args) {
        //Fractional knapsack is Greedy Approach
        int[] wt= new int[]{5,8,10};
        int[] val= new int[]{10,20,30};
        int W= 15;
        double maxProf=getMaxProfitFractionKS(wt, val, W);
        System.out.println("maximum profit in fractional knapsack is: "+maxProf);
    }

    static class ItemValue{
        Double cost;
        double wt, val, i;
        public ItemValue( int w, int v, int i)
        {
            this.wt=w;
            this.val=v;
            this.i=i;
            this.cost=new Double(val/wt);

        }
    }

    private static double getMaxProfitFractionKS(int[] wt, int[] val, int W) {
        ItemValue[] ival= new ItemValue[wt.length];
        for (int i = 0; i < wt.length; i++) {
            ival[i]=new ItemValue(wt[i], val[i], i);
        }

        Arrays.sort(ival, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue=0d;

        for (ItemValue item : ival) {
            int currWt = (int) item.wt;
            int currVal=(int)item.val;

            if(W-currWt>=0){//item can be picked whole
                W=W-currWt;
                totalValue+=currVal;
            }
            else{
                double fraction=((double)W/(double)currWt);
                totalValue+=(currVal*fraction);
                W=(int)(W-(currWt*fraction));
                break;
            }
        }

        return totalValue;
    }
}