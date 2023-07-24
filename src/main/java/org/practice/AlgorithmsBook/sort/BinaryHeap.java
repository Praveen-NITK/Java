package org.practice.AlgorithmsBook.sort;

import java.util.Arrays;

//Max Heap implementation
public class BinaryHeap<T extends Comparable<T>> {
    private T []bhp;
    private int N;
    public BinaryHeap(int cap){
        bhp= (T[]) new Comparable[cap];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(T data){
        if (N >= bhp.length) {
            deleteMax();
        }
        bhp[N] = data;
        swim(N);
        N++;
    }

    private void swim(int pos) {
        while(pos/2>=0 && bhp[pos].compareTo(bhp[pos/2])==1){
            swap(pos,pos/2);
            pos=pos/2;
        }
    }

    private void deleteMax() {
        System.out.println("deleting "+bhp[0]);
        //swap
        swap(0,--N);
        sink(0);
        bhp[N]=null;
    }

    private void swap(int i,int j) {
        T temp=bhp[i];
        bhp[i]=bhp[j];
        bhp[j]=temp;
    }

    private void sink(int pos) {
        while(pos*2<=N){
            int j= pos*2+1;
            //if pos element smaller than its left child
            if(j<N && bhp[pos].compareTo(bhp[j])==-1) {
                j++;
            }
            if(j>N || bhp[pos].compareTo(bhp[j])==1)
                break;
            swap(pos,--j);
            pos=j;
        }
    }

    public static void main(String[] args) {
        BinaryHeap bp=new BinaryHeap(3);
        bp.insert(4);
        bp.insert(5);
        bp.insert(3);
        System.out.println(Arrays.toString(bp.bhp));
        bp.insert(1);
        bp.insert(0);
        bp.insert(2);
        bp.insert(6);
        bp.deleteMax();
        System.out.println(Arrays.toString(bp.bhp));
    }
}
