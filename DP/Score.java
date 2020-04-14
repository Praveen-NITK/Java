package DP;

import java.util.Arrays;
//Goldman Sacs: https://leetcode.com/discuss/interview-question/334671/goldman-sachs-online-assessment-july-2019

public class Score{
    public static void main(String[] args) {
        //System.out.println(System.currentTimeMillis());
        //System.out.println(noOfWaysToScore1(13));
        System.out.println(noOfWaysToScore(13));
        System.out.println(waysToScoreDP(13));
    
    }
    

    // mine O(n^3)
    private static int noOfWaysToScore1(int n) {
        int ways=0;
        if(n==0)
            return 1;        
        if(n<3)
            return 0;
        if(n==3 || n==5 || n==10)
            ways+=1;

        if(n>10)
            ways+=noOfWaysToScore(n-10);
        if(n>5)
            ways+= noOfWaysToScore(n-5);
        if(n>3)
            ways+=noOfWaysToScore(n-3);

        return ways;
    }

    //as book O(n^3)
    private static int noOfWaysToScore(int n) {
        if(n==0)
            return 1;        
        if(n<0)
            return 0;
        return noOfWaysToScore(n-10)+noOfWaysToScore(n-5)+noOfWaysToScore(n-3);
    }

    private static int waysToScoreDP(int n){
        //int []scoreType={3,5,10};
        int []score=new int[n+1];
        Arrays.fill(score, 0);
        score[0]=1;
        for(int i=1;i<=n;i++){
            if(i-3>=0)
                score[i]+=score[i-3];
            if(i-5>=0)
                score[i]+=score[i-5];
            if(i-10>=0)
                score[i]+=score[i-10];
        }

        //Same as coin change
        // for (int j = 1; j < score.length; j++) {
        //     for (int scr : scoreType){
        //         if(j>=scr)
        //             score[j]+=score[j-scr];
        //     }
        // }
        return score[n];
    } 
}