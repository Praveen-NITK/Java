package Others;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;



public class TreeTraversal{
    static class Node{
        int data;
        Node left;
        Node right;
    
        public Node(int d){
            data=d;
            left=null;
            right= null;
        }
    }

    public static void main(String[] args) {
        Node node= new Node(10);
        node.left=new Node(5);
        node.right= new Node(15);
        node.right.left=new Node(12);
        node.right.right=new Node(18);

        //preorderTraversal(node);
        //inOrderTraversal(node);
        postOrderTraversal(node);
        //levelOrderTraversalWithoutQ(node);
        //levelOrderTraversalWithQ(node);
        //DFS(node);
    }

    public static void preorderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data +" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        
        inOrderTraversal(root.left);
        System.out.print(root.data +" ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        
        postOrderTraversal(root.left);        
        postOrderTraversal(root.right);
        System.out.print(root.data +" ");
    }

    //#region Level Order Without Q
    public static void levelOrderTraversalWithoutQ(Node root){
        if(root==null){
            return;
        }
        int height=getHeightofNode(root);
        for(int i=0;i<height;i++){
            printLevelOrder(root,i);
        }        
    }
    private static void printLevelOrder(Node root, int height){
        if(root==null || height<0)
            return;
        if(height==0){
            System.out.println("Node : "+root.data);
        }
        printLevelOrder(root.left, height-1);
        printLevelOrder(root.right, height-1);
    }
    private static int getHeightofNode(Node root){
        if(root==null){
            return 0;
        }
        int lheight=getHeightofNode(root.left);
        int rHeight=getHeightofNode(root.right);
        if(lheight>rHeight)
            return lheight+1;
        return rHeight+1;
    }
    //#endregion

    //#region BFS with Q
    public static void levelOrderTraversalWithQ(Node root){
        Queue que= new LinkedList<Node>();
        que.add(root);

        while(!que.isEmpty()){
            Node node= (Node)que.poll();
            if(node==null){
                continue;
            }
            System.out.println(node.data);
            que.add(node.left);
            que.add(node.right);
        }
    }
    //#endregion

    public static void DFS(Node root){
        Stack stack= new Stack<Node>();

        stack.push(root);

        while(!stack.isEmpty()){
            Node node= (Node)stack.pop();

            if(node==null){
                continue;
            }
            System.out.println(node.data);
            stack.push(node.left);
            stack.push(node.right);
        }
    }
}