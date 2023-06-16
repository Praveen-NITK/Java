package org.practice.Others;

import java.util.Arrays;

public class PaintHouse
{
    public static void main(String args[]){
        int noOfHouse=45;
        int noOfWays1= findNoOfWaysToPaint2(noOfHouse);
        System.out.println("No of ways 1 to paint house is "+noOfWays1);

        int noOfWays2= findNoOfWaysToPaint1(noOfHouse);
        System.out.println("No of ways 2 to paint house is "+noOfWays2);
    }

    //Recursive
    private static int findNoOfWaysToPaint1(int noOfHouse){
        if(noOfHouse<=0){
            return 1;
        }
        if(noOfHouse==1){
            return 2;
        }
        return findNoOfWaysToPaint1(noOfHouse-1)+findNoOfWaysToPaint1(noOfHouse-2);
    }

    //Memoized DP
    private static int findNoOfWaysToPaint2(int noOfHouse){
        int[] house= new int[noOfHouse+1];
        Arrays.fill(house, -1);

        house[0]= 1;
        house[1]= 2;

        if(house[noOfHouse]!=-1){
            return house[noOfHouse];
        }
        for (int i = 2; i < house.length; i++) {            
            house[i]=house[i-1]+house[i-2];
        }
        return house[noOfHouse];
    }
}
