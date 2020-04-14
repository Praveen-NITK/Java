//https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
//https://www.geeksforgeeks.org/must-coding-questions-company-wise/#google
//https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
package MustDo.Google;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel{
    static class Node{
        int data;
        Node left, right, nextRight;

        public Node(int d){
            data=d;
            left=right=nextRight=null;
        }
    }
    public static void main(String[] args) {
        Node root=new Node(5);
        root.left=new Node(3);
        root.right= new Node(4);
        root.left.left=new Node(1);
        root.left.right=new Node(2);
        root.right.right= new Node(6);
        
        connectNode(root);
    }

    private static void connectNode(Node root) {
        Queue<Node> q = new LinkedList<Node>();  
        q.add(root); 
       
        // null marker to represent end of current level 
        q.add(null);  
       
        // Do Level order of tree using NULL markers 
        while (!q.isEmpty()) { 
            Node p = q.peek(); 
            q.remove(); 
            if (p != null) { 
       
                // next element in queue represents next  
                // node at current Level  
                p.nextRight = q.peek(); 
       
                // push left and right children of current 
                // node 
                if (p.left != null) 
                    q.add(p.left);  
                if (p.right != null) 
                    q.add(p.right); 
            }  
              
            // if queue is not empty, push NULL to mark  
            // nodes at this level are visited 
            // Q will have : 5, null, 3, 4, null, 1, 2, 6, null
            else if (!q.isEmpty())  
                q.add(null);  
        } 
    }
}