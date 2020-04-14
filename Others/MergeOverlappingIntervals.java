//https://www.geeksforgeeks.org/merging-intervals/
package Others;

import java.util.Arrays; 
import java.util.Comparator;
import java.util.Stack; 

public class MergeOverlappingIntervals{
    public static class Intervals{
        int start;
        int end;
        public Intervals(int s, int e){
            start=s;
            end=e;
        }
    }
    public static void main(String[] args) {
        Intervals []interval= new Intervals[4];
        interval[0]=new Intervals(2, 4);
        interval[1]=new Intervals(3, 6);
        interval[2]=new Intervals(7, 9);
        interval[3]=new Intervals(8, 12);

        mergeOverlappedIntervals(interval);
    }

    public static void mergeOverlappedIntervals(Intervals[] interval) {
        if(interval.length==0)
            return;
        
        Stack<Intervals> st= new Stack<>();
        Arrays.sort(interval,new Comparator<Intervals>(){ 
            public int compare(Intervals i1,Intervals i2) 
            { 
                return i1.start-i2.start; 
            } 
        });

        st.push(interval[0]);

        for (int i = 1; i < interval.length; i++) {
            Intervals top= st.peek();
            //no overlapping
            if(top.end<interval[i].start){
                st.push(interval[i]);
            }
            else if(top.end<interval[i].end){
                st.pop();
                top.end=interval[i].end;
                st.push(top);
            }
        }

        for (Intervals intv : st) {
            System.out.println("["+intv.start+","+intv.end+"]");
        }


    }
    
}