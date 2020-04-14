//https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
//Also implement
//1. root to leaf all path
//2. root to leaf path for particular sum

package Tree;

import java.util.Stack;

public class RootToNodePath{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right= new Node(5);
        root.right.left=new Node(6);
        root.right.right= new Node(7);

        getRootToNodePathPreOrder(root,5);

        for (Integer val : st) {
            System.out.println(val);
        }
    }
    static Stack<Integer> st= new Stack<>();
    static boolean keyFound=false;
    static boolean leftfromroot=false;

    private static boolean getRootToNodePathPreOrder(Node root, int key) {
        if(root==null)
            return false;
        if(root.data==key){
            st.push(root.data);
            return true;
        }        
        
        return getRootToNodePathPreOrder(root.left, key) || getRootToNodePathPreOrder(root.right, key);
                

        

    }
}