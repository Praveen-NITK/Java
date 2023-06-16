package org.practice.Tree;

import java.util.*;

public class TreeTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) { 
        TreeNode root= new TreeNode(10);
        root.left=new TreeNode(5);
        root.right= new TreeNode(22);
        root.left.left=new TreeNode(1);
        root.left.right= new TreeNode(7);
        root.left.right.left= new TreeNode(6);
        root.left.right.right= new TreeNode(8);
        root.right.left= new TreeNode(12);
        root.right.right= new TreeNode(25);
        //List<Integer> output= preorderTraversalIterative(root);
//        List<Integer> output= breadthFirstTraversal(root);
        //List<Integer> output= postTraversalIterative(root);
        //List<Integer> output=iterativeInOrder(root);
//        System.out.println(output.toString());
        printPreOrderWithIndentation(root,0);
        printPreOrderWithIndentationAndLabel(root,new ArrayList<Integer>());
    }

    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> output= new ArrayList<>();
        Stack<TreeNode> nodeStack=new Stack<>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){
            TreeNode topNode=nodeStack.pop();
            if(topNode!=null){
                output.add(topNode.val);
                nodeStack.push(topNode.right);
                nodeStack.push(topNode.left);
            }
        }
        return output;        
    }

    //using two stacks
    public static List<Integer> postTraversalIterative(TreeNode root) {
        List<Integer> output= new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>(); 
        Stack<TreeNode> s2 = new Stack<>(); 
  
        if (root == null) 
            return null; 
  
        s1.push(root); 
  
        while (!s1.isEmpty()) { 
            TreeNode temp = s1.pop(); 
            s2.push(temp); 
  
            if (temp.left != null) 
                s1.push(temp.left); 
            if (temp.right != null) 
                s1.push(temp.right); 
        } 
  
        while (!s2.isEmpty()) { 
            TreeNode temp = s2.pop(); 
            output.add(temp.val);
        } 
        return output;       
    }

    private static List<Integer> iterativeInOrder(TreeNode root) {
        List<Integer> output= new ArrayList<>();
        Stack<TreeNode> nodeSt= new Stack<>();
        TreeNode current= root;        
        while(current!=null || !nodeSt.isEmpty()){
            
            while(current!=null){
                nodeSt.push(current);
                current=current.left;
            }
            current= nodeSt.pop();
            output.add(current.val);
            current=current.right;            
        }   
        return output;
    }

    private static List<Integer> breadthFirstTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> output= new ArrayList<>();
        if(root!=null)
            queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode current= queue.poll();
            if(current!=null) {
                output.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return output;
    }

    /**
     * 10
     *   5
     *     1
     *     7
     *   22
     *     12
     *     25
     * @param root
     * @param d
     */
    private static void printPreOrderWithIndentation(TreeNode root, int d){
        if(root!=null){
            System.out.println(spaces(2*d)+root.val);
            printPreOrderWithIndentation(root.left,d+1);
            printPreOrderWithIndentation(root.right,d+1);
        }
    }

    private static String spaces(int i) {
        StringBuilder space= new StringBuilder();
        for (int j = 0; j <i; j++) {
            space.append(" ");
        }
        return space.toString();
    }

    /**
     * 10
     *   1 - 5
     *     1.1 - 1
     *     1.2 - 7
     *   2 - 22
     *     2.1 - 12
     *     2.2 - 25
     * @param root
     * @param path
     */
    private static void printPreOrderWithIndentationAndLabel(TreeNode root, ArrayList<Integer> path){
        if(root!=null){
            int d=path.size();
            System.out.print(spaces(2*d));
            for (int i = 0; i <d ; i++) {
                System.out.print(path.get(i)+(i==d-1?" - ":"."));
            }
            System.out.println(root.val);
            path.add(1);

            printPreOrderWithIndentationAndLabel(root.left,path);
            path.set(d,1+path.get(d));
            printPreOrderWithIndentationAndLabel(root.right,path);
            path.remove(d);

        }
    }
}
