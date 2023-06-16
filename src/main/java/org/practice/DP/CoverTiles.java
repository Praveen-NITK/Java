package org.practice.DP;
//An empty plot of size 2*n, cover it with tiles of dimension 2*1, Find total number of ways to cover..
public class CoverTiles{
    public static void main(String[] args) {
        System.out.println(findNoOfWays(4));
        System.out.println(findWaysforDimThree(4));
    }

    private static int findNoOfWays(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        // if we put tiles verically (n-1)+horizontally (n-2)
        return findNoOfWays(n-1)+findNoOfWays(n-2); // Same as fibonnaci except terminating condition
    }

    private static int findWaysforDimThree(int n){
        if(n==0 || n==1)
            return 0;
        if(n==2)
            return 3;
        // if we put tiles verically (n-2)+horizontally (n-2)
        return findWaysforDimThree(n-2)+findWaysforDimThree(n-2);
    }
}
