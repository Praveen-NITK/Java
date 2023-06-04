package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
/* Construct the following tree
                  1
                /  \
               /    \
              2      3
             / \      \
            4   5      6
                      / \
                     7   8
        */
/*
    for 2->3
    for 3->null
    for 4->5
    for 5->6
    for 6->null
* */
public class LevelNextNode {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.right.left=new TreeNode(7);
        root.right.right.right=new TreeNode(8);

        TreeNode next=findNext(root.right.right.left, root);
        if (next!=null)
            System.out.println(next.data);
        else
            System.out.println("null");
    }

    private static TreeNode findNext(TreeNode node, TreeNode root) {
        if(root==null)
            return null;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        TreeNode current;

        while (!q.isEmpty()){
            int size=q.size();

            //another loop to traverse till level only
            while(size-->0) {
                current = q.poll();
                if (current.data == node.data) {
                    if (size==0)
                        return null;
                    return q.peek();
                }
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
            }
        }
        return null;
    }
}
