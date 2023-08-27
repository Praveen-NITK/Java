package org.practice.HackerRank;
// https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

import java.util.Arrays;

/**
 *Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching
 *  pairs of socks that are available.
 * sockMerchant has the following parameter(s):
 * n: the number of socks in the pile
 * ar: the colors of each sock
 */

//https://www.hackerrank.com/interview/interview-preparation-kit/warmup/challenges
public class SocksPair {
    public static void main(String[] args) {
        int[] ar= {6,5,2,3,5,2,2,1,1,5,1};
        System.out.println(sockMerchant(ar.length,ar));
        System.out.println(sockMerchant2(ar.length,ar));
    }

    private static int sockMerchant2(int i, int[] ar) {
        Arrays.sort(ar);
        int count=0;
        int start=0;
        for (int j = 0; j < ar.length-1; j++) {
            if(ar[j]!=ar[j+1]){
                count+=(j-start)/2;
                start=j;
            }
        }
        return count;
    }

    static int sockMerchant(int n, int[] ar) {
        int pair=0;
        int[] aux= new int[101];
        for (int i=0; i<n; i++){
            aux[ar[i]]++;
        }
        for(int j=1;j<=100;j++){
            pair+=aux[j]/2;
        }
        return pair;
    }
}
