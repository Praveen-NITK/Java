package Heap;

import java.util.Arrays;

public class MinHeap{
    int[] Heap;
    int maxSize;
    int heapSize;
    
    MinHeap(int size){
        maxSize=size;
        Heap= new int[size+1];
        Arrays.fill(Heap, -1);
        Heap[0]=Integer.MIN_VALUE;
        //index of heap elements starting from 1
        heapSize=0;
    }
    int parent(int index){
        return index/2;
    }
    int leftChild(int index){
        return 2*index;
    }
    int rightChild(int index){
        return 2*index+1;
    }

    boolean isLeafNode(int index){
        return index<=heapSize && index>heapSize/2;
    }

    void swap(int one, int another){
        int temp=Heap[one];
        Heap[one]=Heap[another];
        Heap[another]=temp;
    }
    
    public void insert(int data){
        Heap[++heapSize]=data;
        int currentIndex=heapSize;
        while(Heap[currentIndex]<Heap[parent(currentIndex)]){
            swap(currentIndex, parent(currentIndex));
            currentIndex=parent(currentIndex);
        }        
    }

    public int extractMin(){
        int popped = Heap[1]; 
		Heap[1] = Heap[heapSize--]; 
		heapify(1); 
		return popped; 
    }

    public void heapify(int index){
        if(isLeafNode(index))
            return;
        if(Heap[index]>Heap[leftChild(index)] || Heap[index]>Heap[leftChild(index)]){
            if(Heap[leftChild(index)]<Heap[rightChild(index)]){
                swap(index, leftChild(index));
                heapify(leftChild(index));
            }
            if(Heap[rightChild(index)]<Heap[leftChild(index)]){
                swap(index, rightChild(index));
                heapify(rightChild(index));
            }
        }            
    }

    void printHeap(){
        for (int i = 1; i <= heapSize/2; i++) {
            System.out.println(Heap[i]+ " leftChild: "+Heap[leftChild(i)]+ " rightChild: "+Heap[rightChild(i)]);
        }
    }

    public static void main(String[] args) {
        MinHeap heap=new MinHeap(10);
        heap.insert(10);
        heap.insert(1);
        heap.insert(7);
        heap.insert(15);
        heap.insert(20);
        heap.insert(12);

        heap.printHeap();

        System.out.println("Min element is: "+heap.extractMin());
        //heap.heapify(1);
        heap.printHeap();

    }

}