package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2= new LinkedList<Integer>();
    public static void main(String[] args) {
        StackUsingQueue st= new StackUsingQueue();
        try{
            st.push(1);
            st.push(2);
            st.push(3);
            st.push(4);
            System.out.println(st.pop());
            st.push(5);
            st.push(6);
            System.out.println(st.pop());
            System.out.println(st.pop());
            System.out.println(st.pop());
            st.push(7);
            System.out.println(st.pop());
            System.out.println(st.pop());
            System.out.println(st.pop());
            System.out.println(st.pop());

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private int pop() throws Exception{
        
        if(q1.isEmpty() && !q2.isEmpty()){
            Queue<Integer> temp;
            temp=q1;
            q1=q2;
            q2=temp;
        }
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        if(q1.isEmpty())
            throw new Exception("Stack is empty");
        return q1.poll();
    }

    private void push(int i) {
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        q1.add(i);
    }
}