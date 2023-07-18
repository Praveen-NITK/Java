package org.practice.Recursion;

// place nxm space with 1*m tiles
public class TilesPlacement {
    public static void main(String[] args) {
        int n=4, m=2;
        int ways= placeTiles(n,m);
        System.out.println(ways);
    }

    private static int placeTiles(int n, int m) {
        //horizontally and vertically equally
        if(n==m)
            return 2;

        //only horizontally
        if(n<m)
            return 1;

        //Horizontally
        int horizontal= placeTiles(n-1, m);

        //vertically
        int vertically= placeTiles(n-m,m);
        return horizontal+vertically;
    }
}
