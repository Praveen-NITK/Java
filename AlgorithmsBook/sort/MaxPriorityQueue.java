package AlgorithmsBook.sort;


//Array Implementation of priority Queue
public class MaxPriorityQueue<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;

    public MaxPriorityQueue(int capacity){
        pq= (Key[]) new Comparable[capacity];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(Key x){
        if(N==pq.length) {
            System.out.println("for inserting "+x);
            deleteMax();
        }
        pq[N++]=x;
    }
    public Key deleteMax(){
        int max=0;
        for (int i = 1; i < N; i++) {
            max=(pq[i].compareTo(pq[max]))>0?i:max;
        }
        Key temp=pq[N-1];
        pq[N-1]=pq[max];
        pq[max]=temp;
        System.out.println("deleting "+pq[--N]);
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(pq[i]+" ");
        }
        System.out.println();
        return pq[N];
    }

    public static void main(String[] args) {
        MaxPriorityQueue pque= new MaxPriorityQueue(10);
        System.out.println(pque.isEmpty());
        pque.insert(10);
        pque.insert(7);
        pque.insert(1);
        pque.insert(2);
        pque.insert(4);
        pque.insert(3);
        pque.insert(6);
        pque.deleteMax();
        System.out.println(pque.isEmpty());
        pque.deleteMax();
        pque.deleteMax();
        pque.insert(5);
        pque.insert(9);
        pque.insert(8);
        pque.insert(15);
        pque.insert(19);
        pque.insert(18);
        pque.insert(25);
        pque.insert(29);
        pque.insert(28);
        pque.deleteMax();


    }

}
