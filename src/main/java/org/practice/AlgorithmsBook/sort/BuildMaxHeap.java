package org.practice.org.practice.AlgorithmsBook.sort;

import java.util.Arrays;

public class BuildMaxHeap<T extends Comparable<T>> {
    int N;
    T[] bhp;

    public BuildMaxHeap(int capacity) {
        bhp = (T[])new Comparable[capacity];
    }
    private void insert(T data){
        if(N>=bhp.length)
            deleteMax();
        bhp[N]=data;
        swim(N);
        N++;
    }

    private void swim(int pos) {
        while (pos/2>=0 && bhp[pos/2].compareTo(bhp[pos])==-1){
            swapElements(pos,pos/2);
            pos=pos/2;
        }
    }

    private void swapElements(int i, int j) {
        T temp=bhp[i];
        bhp[i]=bhp[j];
        bhp[j]=temp;
    }


    private void deleteMax() {
        System.out.println("deleting "+bhp[0]);
        swapElements(0,--N);
        sink(0);
        bhp[N]=null;
    }

    private void sink(int pos) {
        while (pos*2<N){
            int j=pos*2+1;
            if(j<N && bhp[j].compareTo(bhp[pos])==1){
                j++;
            }
            if(j>N || bhp[j].compareTo(bhp[pos])==-1){
                break;
            }
            swapElements(pos,--j);
            pos=j;
        }
    }


    public static void main(String[] args) {
        BuildMaxHeap bh= new BuildMaxHeap(3);
        bh.insert(4);
        bh.insert(5);
        bh.insert(3);
        System.out.println(Arrays.toString(bh.bhp));
        bh.insert(1);
        bh.insert(0);
        bh.insert(2);
        bh.insert(6);
        bh.deleteMax();
        System.out.println(Arrays.toString(bh.bhp));

    }
}
