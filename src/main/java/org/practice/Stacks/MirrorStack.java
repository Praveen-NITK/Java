package org.practice.Stacks;

import java.util.EmptyStackException;
import java.util.Stack;

// No other method than push() pop().... no extra space array or list etc
public class MirrorStack{
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2= new Stack<>();

        st1.push(1);    st1.push(2);    st1.push(3);    st1.push(4);    st1.push(5);

        st2.push(1);    st2.push(2);    st2.push(3);    st2.push(4);    st2.push(5);

        System.out.println("Stack 1 before: "+st1);
        System.out.println("Stack 2 before: "+st2);
        boolean isSame= isStacksIdentical(st1,st2);
        System.out.println("Two stacks are identical: "+isSame);
    }

    private static boolean isStacksIdentical(Stack<Integer> st1, Stack<Integer> st2) {
        int count= 1;
        while(count<st1.size() ){
            int temp=st1.pop();
            if(temp==st2.pop()){
                st1.push(temp);
                st2.push(temp);
            }
            else{                
                return false;
            }
            count++;
        }
        

        System.out.println("Stack 1 after: "+st1);
        System.out.println("Stack 2 after: "+st2);
        return true;
    }
}
