//https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
package org.practice.ArrayPrograms;

public class MinBribe {
    public static void main(String[] args) {
        int q[]={1,2,5,3,7,8,6,4};
        minimumBribes(q);
    }
    static void minimumBribes(int[] q) {
        int bribe=0;
        for(int i=0;i<q.length;i++)
        {
            if((q[i]-(i+1))>2){
                System.out.println("Too chaotic");
                return;
            }
            if(q[i]>(i+1))
                bribe+=q[i]-(i+1);
        }
        System.out.println(bribe);
    }
}
