package org.practice.HackerRank;

public class JumpOnClouds {
    public static void main(String[] args) {
        int []c= {0,0,1,0,0,1,0};  //op-4
        //int []c= {0,0,0,1,0,0};  //op-3
        System.out.println(jumpingOnClouds(c));
    }

    static int jumpingOnClouds(int[] c) {
        int n= c.length;
        int jump=0;
        for(int i=0;i<n-1;){
            if((i+2) < n && c[i+2]==0)
                i=i+2;
            else
                i=i+1;
            jump++;
        }
        return jump;
    }
}
