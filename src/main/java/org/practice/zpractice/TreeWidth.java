package org.practice.zpractice;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TreeWidth {
    static class Node{
        private int data;
        private Node left,right;
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


        Set<Integer> distanceSet= new HashSet<>();
        getWidth(distanceSet,root,0);
        System.out.println(distanceSet.size());
    }

    private static void getWidth(Set<Integer> distanceSet,Node root,int current) {
        distanceSet.add(current);
        if(root ==null)
            return;
        if(root.left!=null)
            getWidth(distanceSet,root.left,current-1);
        if(root.right!=null)
            getWidth(distanceSet,root.right,current+1);
    }
}
