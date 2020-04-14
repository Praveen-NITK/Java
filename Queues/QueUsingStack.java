package Queues;

import java.util.Stack;

public class QueUsingStack{
    public static void main(String[] args) {
        int []numbers= {1,2,3,4,5};
        QueUsingStack qus= new QueUsingStack();
        for (int i : numbers) {
            qus.enqueue(i);
        }  
        try{      
            System.out.println(qus.deQueue());
            qus.enqueue(6);
            System.out.println(qus.deQueue());
            qus.enqueue(7);
            System.out.println(qus.deQueue());
            System.out.println(qus.deQueue());
            qus.enqueue(8);
            qus.enqueue(9);
            
            System.out.println(qus.deQueue());
            System.out.println(qus.deQueue());            
            System.out.println(qus.deQueue());            
            qus.enqueue(10);
            System.out.println(qus.deQueue());
            System.out.println(qus.deQueue());
            System.out.println(qus.deQueue());
            System.out.println(qus.deQueue());
            System.out.println(qus.deQueue());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    Stack<Integer> st1= new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    public void enqueue(int x){
        while(!st2.empty()){
            st1.push(st2.pop());
        }
        st1.push(x);              
    }
    public int deQueue() throws Exception{        
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        if(st2.empty())
            throw new Exception("!!Error Stack is empty"); 
        return st2.pop();
    }
}