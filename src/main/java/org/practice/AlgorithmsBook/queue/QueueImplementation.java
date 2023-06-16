package org.practice.AlgorithmsBook.queue;

public interface QueueImplementation<T> {
    void enqueue(T t);
    void dequeue();
    boolean isEmpty();
}
