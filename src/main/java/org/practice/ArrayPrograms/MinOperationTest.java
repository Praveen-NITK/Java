package org.practice.ArrayPrograms;

import java.util.LinkedList;

public class MinOperationTest {
    static class Operation{
        private int item;
        private int steps;

        public Operation(int item, int steps) {
            this.item = item;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        int noOfSteps=getMinSteps(4,5);
        System.out.println(noOfSteps);
    }

    private static int getMinSteps(int src, int target) {
        int stepCount=0;
        LinkedList<Operation> queue= new LinkedList<>();
        queue.add(new Operation(src,0));

        while (!queue.isEmpty()){
            stepCount++;
            Operation temp= queue.poll();

            if(temp.item==target){
                return temp.steps;
            }

            temp.item*=2;
            temp.steps=temp.steps+1;
            if(temp.item>0 && temp.item<1000){
                queue.offer(temp);
            }

            temp.item-=1;
            temp.steps=temp.steps+1;
            if(temp.item>0 && temp.item<1000){
                queue.offer(temp);
            }

        }
        return stepCount;

    }
}
