package org.practice.BST;
public class IsBST{
    public static class Node{
        int data;
        Node left,right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }

    
    public static boolean isBST(Node root){
        if(root==null)
            return true;
        if(root.left!=null && root.left.data>root.data)
            return false;
        if(root.right!=null && root.right.data<root.data)
            return false;
        return isBST(root.left) && isBST(root.right);
    }
    public static void main(String[] args) {
        Node root= new Node(50);
        root.left=new Node(30);
        root.right=new Node(20);
        root.left.right= new Node(40);

        System.out.println(isBST(root));
    }
}
