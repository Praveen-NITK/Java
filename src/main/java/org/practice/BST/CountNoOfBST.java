package org.practice.BST;
//https://www.geeksforgeeks.org/count-the-number-of-binary-search-trees-present-in-a-binary-tree/
// A Binary Tree is a Binary Search Tree if the following are true for every node x.
// 1. The largest value in left subtree (of x) is smaller than value of x.
// 2. The smallest value in right subtree (of x) is greater than value of x.

public class CountNoOfBST{
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

    static class BstInfo{
        int bstCount;
        boolean isBst;
        int max;
        int min;
        
        BstInfo(int a, boolean b, int c, int d){
            bstCount=a;
            isBst=b;
            max=c;
            min=d;
        }
        BstInfo(){}
    }

    public static BstInfo countBst(Node tree){
        if(tree==null){
            return new BstInfo(0,false,0,0);            
        }
        if(tree.left==null && tree.right==null){
            return new BstInfo(1, true, tree.data, tree.data);
        }

        BstInfo left  = countBst(tree.left);
        BstInfo right = countBst(tree.right);

        BstInfo bst= new BstInfo();

        if(left.isBst && right.isBst && tree.data>left.max && tree.data<right.min){
            bst.min=Math.min(tree.data, Math.min(left.min, right.min));
            bst.max=Math.max(tree.data, Math.max(left.max, right.max));
            bst.isBst=true;
            bst.bstCount=2+left.bstCount+right.bstCount;
            return bst;
        }

        bst.isBst=false;
        bst.bstCount=1+left.bstCount+right.bstCount;

        return bst;
    }

    public static void main(String[] args) {
        Node tree= new Node(50);
        tree.left=new Node(40);
        tree.left.left= new Node(30);
        tree.left.right=new Node(45);
        tree.right=new Node(60);
        tree.right.right=new Node(65);

        BstInfo bstInfo=countBst(tree);
        System.out.println(bstInfo.bstCount);
    }
}
