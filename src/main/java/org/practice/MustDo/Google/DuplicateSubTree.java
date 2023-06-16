//https://www.geeksforgeeks.org/check-binary-tree-contains-duplicate-subtrees-size-2/
package org.practice.MustDo.Google;

import java.util.HashSet;

public class DuplicateSubTree {

    static char  MARKER='$';

    static class Node{
        char data;
        Node left, right;
        public Node(char d){
            data=d;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node('A');  
        root.left = new Node('B');  
        root.right = new Node('C');  
        root.left.left = new Node('D');  
        root.left.right = new Node('E');  
        root.right.right = new Node('B');  
        root.right.right.right = new Node('E');  
        root.right.right.left= new Node('D');  
        String str = dupSub(root);  
        if(str.equals("")) 
            System.out.print(" Yes "); 
        else    
            System.out.print(" No ");  
    }

    private static String dupSub(Node root) {
        HashSet<String> subtrees=new HashSet<>(); 
        return dupSubUtil(root,subtrees); 
    }

    private static String dupSubUtil(Node root, HashSet<String> subtrees) {
        
        String s="";
        if(root==null)
            return s+MARKER;
        String lStr=dupSubUtil(root.left, subtrees);
        if(lStr.equals(s))
            return s;

        String rStr=dupSubUtil(root.right, subtrees);
        if(rStr.equals(s))
            return s;
        
        s=s+lStr+root.data+rStr;
        
        //Note that size of a serialized tree with single node is 3 as it has two marker nodes
        if (s.length() > 3 && subtrees.contains(s))  
            return "";  
    
        subtrees.add(s);
        return s;
        
    }
}
