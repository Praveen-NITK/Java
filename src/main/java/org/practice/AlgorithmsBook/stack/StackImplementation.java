package org.practice.AlgorithmsBook.stack;

public interface StackImplementation<T> {
    void push(T t);
    void pop();
    boolean isEmpty();
}
