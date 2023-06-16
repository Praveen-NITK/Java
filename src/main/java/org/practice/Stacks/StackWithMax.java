package org.practice.Stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /* LIFO (similar to a stack), but also implements a getMaximum function.
 * void push(int x){}
 * int pop(){}
 * int top(){}
 * int getMaximum(){}
 *
 * 2 1 3 5 4
 *
 * max = 5
 *
 * */
public class StackWithMax {

    static List<Integer> st =new ArrayList<>();
    static Map<Integer, Integer> maxMap=new HashMap<>();
    static int top=-1;

    private static void push(int num){
        st.add(num);
        top=num;
        int length=st.size();
        if(length>1)
            maxMap.put(length-1, Math.max(maxMap.get(length-2), num));
        else
            maxMap.put(0,num);
    }

    private static int pop(){
        int popElem= st.remove(st.size()-1); //3
        top=st.get(st.size()-1); //2
        return popElem;
    }

    private static int top(){
        return top;
    }

    private static int getMaximum(){
        return maxMap.get(st.size()-1);
    }

    public static void main(String[] args) {
        push(2);
        System.out.println(top());
        push(3);
        System.out.println(pop());
        push(5);
        System.out.println(getMaximum());
        System.out.println(pop());
        System.out.println(getMaximum());
    }

}
