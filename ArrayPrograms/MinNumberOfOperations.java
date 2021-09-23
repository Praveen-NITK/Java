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
        System.out.println(noOfSteps);
    }

    private static int getMinNumberOfSteps(int source, int target) {
        //Set<Operation> visited= new HashSet<>();
        LinkedList<Operation> queue= new LinkedList<>();

        Operation op= new Operation(source, 0);
        queue.add(op);
        //visited.add(op);
        int count=0;
        while(!queue.isEmpty()){
            count++;
            Operation temp= queue.poll();
            //visited.add(temp);
            if(temp.val==target){
                System.out.println("count -->"+count);
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

    public static void minNoOperation() {
        int x=0;
        int y=5;
        int count=0;
        while(x<y){
            x=x*2;
            count++;
        }
        while(x>y){
            x--;
            count++;
        }

        System.out.println(count);
    }

}