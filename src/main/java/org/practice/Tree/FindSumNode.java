package org.practice.Tree;
//Example 7.2 in Dynamic programming book amazon.
public class FindSumNode{
    static class Tree{
        int data;
        Tree left,right;
        public Tree(int d){
            data=d;
            left=right=null;
        }
    }
    public static void preorder(Tree node){
        if(node==null)
            return;
        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        //System.out.println("hello");
        Tree root=new Tree(2);
        root.left=new Tree(4);
        root.left.left= new Tree(6);
        root.left.right=new Tree(9);
        root.left.right.left=new Tree(3);
        root.right=new Tree(1);
        root.right.right=new Tree(2);

        preorder(root);
        Tree resulted=addBelowNodes(root);
        System.out.println("--------");
        preorder(resulted);
    }

	private static Tree addBelowNodes(Tree root) {
        if(root==null){
            return root;
        }
        if(root.left!=null )
            root.data+=addBelowNodes(root.left).data;
        if(root.right!=null )
            root.data+= addBelowNodes(root.right).data;
        
        return root;
    }    
}
