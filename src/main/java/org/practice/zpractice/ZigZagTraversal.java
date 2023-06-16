package org.practice.zpractice;

import java.util.Stack;

public class ZigZagTraversal {
    static class Node{
        private int data;
        private Node left,right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(201);
        root.left.right=new Node(202);
        root.left.right.left=new Node(2021);
        root.right.left=new Node(301);
        root.right.right=new Node(302);
        root.right.right.left=new Node(3021);
        printZigZagTraversal(root);
    }

    private static void printZigZagTraversal(Node root) {
//        System.out.println(heightOfTree);
        zigZagLevel(root);
    }

    private static void zigZagLevel(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2= new Stack<>();
        if(root!=null);
            s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()){
            while (!s1.isEmpty()){
                Node curr= s1.pop();
                System.out.println(curr.data);
                if(curr.left!=null)
                    s2.push(curr.left);
                if(curr.right!=null)
                    s2.push(curr.right);
            }
            while (!s2.isEmpty()){
                Node curr= s2.pop();
                System.out.println(curr.data);
                if(curr.right!=null)
                    s1.push(curr.right);
                if(curr.left!=null)
                    s1.push(curr.left);
            }
        }
    }
}
