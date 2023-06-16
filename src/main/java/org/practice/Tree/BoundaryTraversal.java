package org.practice.Tree;

//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
public class BoundaryTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node node=new Node(20);
        node.left=new Node(8);
        node.right=new Node(22);
        node.left.left=new Node(4);
        node.left.right=new Node(12);
        node.left.right.left=new Node(10);
        node.left.right.right=new Node(14);
        node.right.right=new Node(25);
        printBoundary(node);
    }

    private static void printBoundary(Node node) {
        if(node==null)
            return;
        System.out.println(node.data);

        printLeftBoundary(node.left);

        //Leaf node for left subtree
        printLeafNodes(node.left);

        //Leaf node for right subtree
        printLeafNodes(node.right);

        printRightBoundary(node.right);
    }

    private static void printLeafNodes(Node node) {
        if(node==null)
            return;
        if(node.left==null && node.right==null){
            System.out.println(node.data);
        }
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }


    private static void printLeftBoundary(Node node) {
        if(node==null)
            return;
        //Print top to Down - so print first then recursive call
        if(node.left!=null){
            System.out.println(node.data);
            printLeftBoundary(node.left);
        } else if (node.right!=null){
            System.out.println(node.data);
            printLeftBoundary(node.right);
        }
    }

    private static void printRightBoundary(Node node) {
        if(node==null)
            return;
        //Print bottom to top - so call recursive first then print
        if(node.right!=null){
            printRightBoundary(node.right);
            System.out.println(node.data);
        }
        else if(node.left!=null){
            printRightBoundary(node.left);
            System.out.println(node.data);
        }
    }
}
