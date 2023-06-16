//https://www.geeksforgeeks.org/replace-node-binary-tree-sum-inorder-predecessor-successor/
package org.practice.Tree;

import java.util.Arrays;

public class SumInOrderPredSucc{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node tnode= new Node(1);
        tnode.left=new Node(2);
        tnode.right=new Node(3);
        tnode.left.left=new Node(4);
        tnode.left.right=new Node(5);
        tnode.right.left=new Node(6);
        tnode.right.right=new Node(7);

        int[] in=new int[7];
        int[] sum=new int[in.length];
        in=printInorder(tnode,in);
        System.out.println(" ");
        for (int i = 0; i < in.length; i++) {
            if(i-1>=0)
                sum[i]+=in[i-1];
            if(i+1<in.length)
                sum[i]+=in[i+1];
        }

        for (int i = 0; i < sum.length; i++) {
            System.out.print(" "+sum[i]);
        }
    }
    static int count=0;
    private static int[] printInorder(Node tnode, int[] inSeq) {
        
        if(tnode==null)
            return null;
        printInorder(tnode.left,inSeq);
        System.out.print(" "+tnode.data);
        inSeq[count++]=tnode.data;
        printInorder(tnode.right, inSeq);
        return inSeq;
    }
}