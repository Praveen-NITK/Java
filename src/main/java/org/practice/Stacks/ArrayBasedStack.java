package org.practice.Stacks;

public class ArrayBasedStack<E> implements Stack<E> {
    public static final int CAPACITY=1000;
    int t=-1;
    private E[] data;
    public ArrayBasedStack(){
        this(CAPACITY);
    }
    public ArrayBasedStack(int size){
        data= (E[])new Object[size];
    }

    @Override
    public int size() {
        return t+1;
    }

    @Override
    public boolean isEmpty() {
        return t==-1;
    }

    @Override
    public void push(E e) throws IllegalStateException{
        if(data.length==size())
            throw new IllegalStateException("Stack is full");
        data[++t]=e;
    }

    @Override
    public E pop() throws IllegalStateException{
        if(isEmpty())
            return null;
        E answer=data[t];
        data[t--]=null;
        return answer;
    }

    @Override
    public E top() {
        if(isEmpty())
            return null;
        return data[t];
    }

    public static void main(String[] args) {
        ArrayBasedStack<Integer> st1= new ArrayBasedStack<>(5);
        st1.push(4);
        st1.push(3);
        System.out.println(st1.pop());
        st1.push(7);
        System.out.println(st1.top());
        System.out.println(st1.top());
        System.out.println(st1.pop());
    }
}
