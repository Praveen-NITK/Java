package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        root.right.left= new TreeNode(12);
        root.right.right= new TreeNode(25);
        List<Integer> output= preorderTraversalIterative(root);
        //List<Integer> output= postTraversalIterative(root);
        //List<Integer> output=iterativeInOrder(root);
        System.out.println(output);
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
}