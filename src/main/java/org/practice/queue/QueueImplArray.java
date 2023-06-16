package org.practice.queue;

public class QueueImplArray<E> implements QueueInterface<E> {
    public static final int CAPACITY=1000;
    E[] data;
    public QueueImplArray(){data=(E[])new Object[CAPACITY];}
    public QueueImplArray(int size){data= (E[]) new Object[size];}
    int t=-1;

    //O(1)
    @Override
    public void enqueue(E e) throws IllegalStateException{
        if(t>=CAPACITY)
            throw new IllegalStateException("Que is full!!");
        data[++t]=e;

    }

    //O(n)
    @Override
    public E dequeue() throws IllegalStateException{
        if(isEmpty())
            throw new IllegalStateException("!Q is empty");
        E result=data[0];
        for (int i = 0; i <data.length-1 ; i++) {
            data[i]=data[i+1];
        }
        t--;
        return result;
    }

    //O(1)
    @Override
    public int size() {
        return t+1;
    }

    //O(1)
    @Override
    public boolean isEmpty() {
        return t==-1;
    }

    //O(1)
    @Override
    public E first() throws IllegalStateException{
        if(isEmpty())
            throw new IllegalStateException("!Q is empty");
        return data[0];
    }

    public static void main(String[] args) {
        QueueImplArray<Integer> q=new QueueImplArray<>();
        q.enqueue(6);
        q.enqueue(7);
        System.out.println(q.first());
        System.out.println(q.size());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());

//        System.out.println(q.dequeue());
    }
}
