//https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
//Also implement
//1. root to leaf all path
//2. root to leaf path for particular sum

package Tree;

import java.util.ArrayList;

public class RootToNodePath{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right= new Node(5);
        root.right.left=new Node(6);
        root.right.right= new Node(7);

        ArrayList<Integer> path = new ArrayList<>();
        isRootToNodePath(root,7,path);

        for (Integer val : path) {
            System.out.print(val+" "); //1 3 7
        }
    }

    private static boolean isRootToNodePath(Node root, int key, ArrayList<Integer> path) {
        if(root==null)
            return false;
        path.add(root.data);
        if(root.data==key)
            return true;
        if(isRootToNodePath(root.left, key, path) || isRootToNodePath(root.right, key,path)){
            return true;
        }
        else {
            path.remove(path.size()-1);
            return false;
        }

    }
}