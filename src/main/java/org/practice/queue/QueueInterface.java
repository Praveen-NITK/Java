package queue;

public interface QueueInterface<E> {
    void enqueue(E e);
    E dequeue();
    int size();
    boolean isEmpty();
    E first();
}
