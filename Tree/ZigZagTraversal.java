////https://www.geeksforgeeks.org/zig-zag-level-order-traversal-of-a-tree-using-single-queue/
package Tree;

import java.util.Stack;

public class ZigZagTraversal{
    static class Node{
        int data;
        Node left,right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        // int height=getHeight(root);

        // for (int i = 0; i < height; i++) {
        //     if(i%2==0)
        //         printZigZagLevel(root,i,true);
        //     else
        //         printZigZagLevel(root,i,false);
        // }

        printZigZagIterative(root);
        
    }

    

    private static int getHeight(Node root) {
        if(root==null)
            return 0;
        int lheight=getHeight(root.left);
        int rheight= getHeight(root.right);
        if(lheight>rheight)
            return lheight+1;
        else
            return rheight+1;
    }

    private static void printZigZagLevel(Node root2, int i,Boolean isEven) {
        if(root2==null || i<0)
            return;
        if(i==0)
            System.out.println(root2.data);
        if(isEven){
            printZigZagLevel(root2.left, i-1,isEven);
            printZigZagLevel(root2.right, i-1,isEven);
        }
        else{
            printZigZagLevel(root2.right, i-1,!isEven);
            printZigZagLevel(root2.left, i-1, !isEven);
        }
    }

    private static void printZigZagIterative(Node root) {
        if(root==null)
            return;
        Stack<Node> stack1=new Stack<Node>();
        Stack<Node> stack2=new Stack<Node>();
        
        stack1.push(root);
        while(!stack1.empty() || !stack2.empty()){
            while(!stack1.empty()){
                Node current=stack1.pop();
                System.out.println(current.data);
                if(current.left!=null)
                    stack2.push(current.left);
                if(current.right!=null)
                    stack2.push(current.right);
            }
            while(!stack2.empty()){
                Node current=stack2.pop();
                System.out.println(current.data);                
                if(current.right!=null)
                    stack1.push(current.right);
                if(current.left!=null)
                    stack1.push(current.left);
            }
        }
    }
}