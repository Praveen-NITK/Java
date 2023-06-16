package org.practice.queue;

import java.util.LinkedList;

public class QueueImplLinkedList<E> implements QueueInterface<E> {
    LinkedList<E> data;
    public QueueImplLinkedList(){data= new LinkedList<>();}

    //O(1)
    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    //O(1)
    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    //O(1)
    @Override
    public int size() {
        return data.size();
    }

    //O(1)
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //O(1)
    @Override
    public E first() {
        return data.getFirst();
    }

    public static void main(String[] args) {
        QueueImplLinkedList<Integer> q=new QueueImplLinkedList<>();
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
