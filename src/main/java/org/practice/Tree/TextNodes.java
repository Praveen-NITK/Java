//Groupon: Node is either text node or having
//all text nodes are leaf node
// all other nodes must have two childs
//print the character for given position 3:c, 7:g etc
package org.practice.Tree;

import java.util.Stack;

public class TextNodes{
    static String s="";
    static class Node{
        String value;
//        boolean isTextNode;
        Node left,right;

        Node(String v){
            value=v;
            left=right=null;
        }

    }
    public static void main(String[] args) {
        Node root= new Node(null);
        root.left=new Node(null);
        root.left.left= new Node("abcd");
        root.left.right= new Node("efg");
        root.right=new Node(null);


        int position= 3;
//      getCharAtPosition(root );
        s=getCharPosition(root);
        System.out.println("String at "+position+"  is: "+s.charAt(position-1));

    }

    private static void getCharAtPosition(Node root) {
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            s+=root.value;
        }
        getCharAtPosition(root.left);
        getCharAtPosition(root.right);
    }
    private static String getCharPosition(Node root) {
        Stack<Node> s= new Stack<>();
        s.push(root);
        String str="";
        while(!s.isEmpty())
        {
            Node current= s.pop();
            if(current.left==null && current.right==null){
                str+=current.value;
            }
            if(current.left!=null)
                s.push(current.right);
            if(current.right!=null)
                s.push(current.left);
        }
        return str;
    }
}
