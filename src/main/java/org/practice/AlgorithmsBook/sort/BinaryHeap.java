package org.practice.AlgorithmsBook.sort;

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
        if(N<=bhp.length) {
            bhp[N] = data;
            swim(N);
            N++;
        }
        else
            deleteMax();
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
        bhp[N+1]=null;
    }

    private void swap(int i,int j) {
        T temp=bhp[i];
        bhp[i]=bhp[j];
        bhp[j]=temp;
    }

    private void sink(int pos) {
        while(pos*2<=N){
            int j= pos*2+1;
            if(j<N && bhp[pos].compareTo(bhp[j])==-1) {
                j++;
            }
            if(j<N && bhp[pos].compareTo(bhp[j])==1)
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
        bp.deleteMax();
    }
}
