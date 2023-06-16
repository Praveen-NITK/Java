package org.practice.queue;

public interface CircularQ<E> extends QueueInterface<E> {
    void rotate();
}
