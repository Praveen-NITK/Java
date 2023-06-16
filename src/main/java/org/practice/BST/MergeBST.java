package org.practice.BST;
//https://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/
//Insert elements of the first tree to second
public class MergeBST{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    static void printInOder(Node tree){
        if(tree==null){
            return;
        }        
    }

    public static void main(String[] args) {
        Node bst1= new Node(50);
        bst1.left= new Node(30);
        bst1.left.left= new Node(20);
        bst1.left.right=new Node(40);
        bst1.right=new Node(70);
        bst1.right.left=new Node(60);
        bst1.right.right=new Node(80);

        Node bst2= new Node(5);
        bst2.left= new Node(3);
        bst2.left.left= new Node(2);
        bst2.left.right=new Node(4);
        bst2.right=new Node(7);
        bst2.right.left=new Node(6);
        bst2.right.right=new Node(8);

        //Node tree= mergeBst(bst1,bst2);
        //printInOder(tree);
    }
}
