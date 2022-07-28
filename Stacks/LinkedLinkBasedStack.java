package Stacks;

import java.util.LinkedList;

public class LinkedLinkBasedStack<E> implements Stack<E> {
    int t=-1;
    LinkedList<E> data;
    public LinkedLinkBasedStack(){
        data=new LinkedList<E>();
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
    public void push(E e) {
        data.add(++t,e);
    }

    @Override
    public E pop() throws IllegalStateException{
        if(isEmpty()) {return null;}
        E result= data.get(t);
        data.remove(t--);
        return result;
    }

    @Override
    public E top() {
        return data.get(t);
    }

    public static void main(String[] args) {
        LinkedLinkBasedStack<Integer> st2 = new LinkedLinkBasedStack<>();
        st2.push(4);
        st2.push(3);
        System.out.println(st2.pop());
        st2.push(7);
        System.out.println(st2.top());
        System.out.println(st2.size());
        System.out.println(st2.top());
        System.out.println(st2.pop());
    }
}
