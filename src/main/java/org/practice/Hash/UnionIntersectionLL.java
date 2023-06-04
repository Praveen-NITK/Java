package Hash;
import java.util.HashSet;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
public class UnionIntersectionLL{
    public static void main(String[] args) {
        LinkedList<Integer> ll1= new LinkedList<>();
        LinkedList<Integer> ll2=new LinkedList<>();
        ll1.add(10);
        ll2.add(20);
        ll1.add(20);
        //System.out.println(ll1);

        //printUnion(ll1,ll2);
        printIntersection(ll1,ll2);
    }

    private static void printIntersection(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        HashSet<Integer> hSet= new HashSet<>();
        for (Integer var : ll1) {
            hSet.add(var);
        }
        for (Integer var : ll2) {
            if(hSet.contains(var)){
                System.out.println(var);
            }
        }
    }

    private static void printUnion(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        HashSet<Integer> hSet= new HashSet<>();
        for (Integer var : ll1) {
            hSet.add(var);
        }
        for (Integer var : ll2) {
            hSet.add(var);
        }
        System.out.println(hSet);
    }
}