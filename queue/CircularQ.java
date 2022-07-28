package queue;

public interface CircularQ<E> extends QueueInterface<E> {
    void rotate();
}
