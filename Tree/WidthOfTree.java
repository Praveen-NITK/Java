package Tree;

import java.util.HashSet;
import java.util.Set;

public class WidthOfTree{
    static class Node{
        int data;
        Node left,right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.right.right= new Node(4);
        //root.right.right.right= new Node(5);
        root.right.right.left= new Node(6);
        root.right.right.left.left= new Node(7);
        root.right.right.left.left.left= new Node(16);

        //root.right.right.left.right.right.right=new Node(32);

        Set<Integer> set= new HashSet<>();

        getWidth(root, set, 0);
        System.out.println("Width of tree is: "+set.size());
        System.out.println(set);

    }

    // static class Width{
    //     static int minVal=0;
    //     static int maxVal=0;
    // }
    // Width w= new Width();
    private static void getWidth(Node root, Set<Integer> set, int curr) {
        if(root==null)
            return;

        getWidth(root.left, set, curr-1);

        set.add(curr);
        
        getWidth(root.right, set,curr+1);
        
    }
}