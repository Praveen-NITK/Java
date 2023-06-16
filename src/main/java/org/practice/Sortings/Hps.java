package org.practice.Sortings;
public class Hps{
    public static void main(String[] args) {
        int[] inp= new int[]{2,5,1,8,4,3};
        System.out.println(sort(inp));
    }

    private static char[] sort(int[] inp) {

        int n= inp.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(inp, n,i);
        }

        for(int i=n-1;i>=0;i--){
            int temp=inp[i];
            inp[i]=inp[0];
            inp[0]=temp;
            heapify(inp, i, 0);
        }

        return null;
    }

    private static void heapify(int[] inp, int n, int i) {
        int larger=i;
        int left=0;
        int right=0;

        if(left<n && inp[larger]<inp[left])
            larger=left;
        if(right<n && inp[larger]<inp[right])
            larger=right;
        if(larger!=i){

        }
    }
}
