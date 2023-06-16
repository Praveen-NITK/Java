package org.practice.AlgorithmsBook.stack;

public class ArrayStackOfStrings implements StackImplementation<String>{
    String[] st= new String[1];
    int N=0;
    public boolean isEmpty(){
        return N==0;
    }
    public void push(String s){
        if(st.length==N)
            resize(st.length*2);
        st[N++]=s;
    }

    private void resize(int capacity) {
        String [] newSt= new String[capacity];
        for (int i = 0; i < N; i++) {
            newSt[i]=st[i];
        }
        st=newSt;
    }

    public void pop(){
        System.out.println(st[--N]);
        if(N==st.length/4)
            resize(st.length/2);
    }

    public static void main(String[] args) {
        ArrayStackOfStrings s =new ArrayStackOfStrings();
        s.push("ram");
        s.push("mohan");
        s.pop();
        System.out.println(s.isEmpty());
        s.push("radha");
        s.pop();
        s.pop();
        System.out.println(s.isEmpty());
    }
}
