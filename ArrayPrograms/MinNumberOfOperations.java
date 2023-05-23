package ArrayPrograms;
//https://www.geeksforgeeks.org/minimum-number-operation-required-convert-number-x-y/

import java.util.LinkedList;

public class MinNumberOfOperations{
    static class Operation{
        int val;
        int steps;
        public Operation(int v, int s){
            val=v;
            steps=s;
        }
    }

    public static void main(String[] args) {
        int noOfSteps=getMinNumberOfSteps(4,5);
        int noOfStepsR=getMinNumberOfStepsRecursive(4,7);
        System.out.println(noOfSteps);
        System.out.println(noOfStepsR);
    }

    private static int getMinNumberOfSteps(int source, int target) {
        LinkedList<Operation> queue= new LinkedList<>();

        Operation op= new Operation(source, 0);
        queue.add(op);
        //int count=0;
        while(!queue.isEmpty()){
            //count++;
            Operation temp= queue.poll();
            if(temp.val==target){
                //System.out.println("count -->"+count);
                return temp.steps;
            }

            int mul=temp.val*2;
            int sub=temp.val-1;

            if(mul>0 && mul<1000){
                Operation newOperation= new Operation(mul, temp.steps+1);
                queue.offer(newOperation);
            }
            if(sub>0 && sub<1000){
                Operation newOperation= new Operation(sub, temp.steps+1);
                queue.offer(newOperation);
            }
        }

        return -1;
    }

    private static int getMinNumberOfStepsRecursive(int source, int target) {
        if(source==target)
            return 0;
        if(source>target)
            return source-target;

        // If target is odd
        if(target%2!=0)
            return 1+getMinNumberOfStepsRecursive(source,target+1);
        //If target is even
        else
            return 1+getMinNumberOfStepsRecursive(source,target/2);
    }
}