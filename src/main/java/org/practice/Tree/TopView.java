package org.practice.Tree;

import java.util.Stack;
import java.util.TreeMap;

public class TopView{
    static class Node{
        int data;
        Node left, right;
        public Node(int d){
            data=d;            
            left=right=null;
        }
    }
    
    static Node root=null;
    
    public static void main(String[] args) {
        // Node root= new Node(1);
        // root.left=new Node(2);
        // root.right= new Node(3);
        // root.right.right= new Node(4);
        // root.right.right.left= new Node(6);
        // root.right.right.left.right= new Node(7);
        // root.right.right.left.right.right= new Node(8);

        // Node root=new Node(1);
        // root.left=new Node(2);
        // root.right= new Node(3);
        // root.left.left=new Node(4);
        // root.left.right=new Node(5);
        // root.right.left=new Node(6);
        // root.right.right=new Node(7);
        // root.left.right.right=new Node(8);
        // root.left.right.right.right=new Node(9);

        int[] nodeList= new int[]{47,2,40,20,38,30,14,28,10,16,19,44,39,27,7,9,31,12,43,21,5,41,34,49,13,33,3,4,25,22,29,15,32,35,6,24,23,26,1,11,42,36,37,17,18,8,45,48,50,46};
        for (int var : nodeList) {
            root= constructBst(root, var);
        }
        

        TreeMap<Integer, Integer> h= new TreeMap<>();

        getLeftTopView(root,0,h );
        getRightTopView(root,0,h );        
        for (int var : h.values()) {
            System.out.print(var +" ");
            
        }

    }

    private static Node constructBst(Node root, int d) {
        if(root==null){
            return new Node(d);
        }
        if(d<root.data){
            root.left= constructBst(root.left,d);
        }
        else if(d>root.data){
            root.right= constructBst(root.right,d);
        }
        return root;
    }

    private static void getLeftTopView(Node root,int position, TreeMap<Integer, Integer> h) {
        if(root==null)
            return;
        if(h.get(position)==null && position<=0)
            h.put(position,root.data);        
        
        getLeftTopView(root.left, position-1,h);
        getLeftTopView(root.right,position+1,h);  
    }
    private static void getRightTopView(Node root,int position, TreeMap<Integer, Integer> h) {
        if(root==null)
            return;
        if(h.get(position)==null && position>0)
            h.put(position,root.data);
            
        getRightTopView(root.right,position+1,h);
        getRightTopView(root.left, position-1,h);
    }
}
