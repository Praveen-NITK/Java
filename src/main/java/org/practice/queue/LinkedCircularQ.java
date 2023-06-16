package org.practice.queue;

public class LinkedCircularQ<E> extends QueueImplLinkedList<E> implements CircularQ<E> {

    @Override
    public void rotate() {
        data.addLast(data.removeFirst());
    }
}
