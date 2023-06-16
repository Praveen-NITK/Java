package org.practice.Others;
public class Heap{
    
    static TreeNode head=null;

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    static void constructTree(){
        head=new TreeNode(10);
        head.left=new TreeNode(5);
        head.right=new TreeNode(15);

        head.left.left=new TreeNode(3);
        head.left.right=new TreeNode(8);

        head.right.left=new TreeNode(13);
        head.right.right=new TreeNode(18);

        head.right.right.left=new TreeNode(16);
    }

    //static 


    public static void main(String[] args) {
        constructTree();

        

    }
}
