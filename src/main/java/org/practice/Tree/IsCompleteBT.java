package Tree;
//Iterative
//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/

//Recursive
//https://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/
public class IsCompleteBT{
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        Node root= new Node(10);
        root.left= new Node(20);
        root.right= new Node(30);
        root.left.left= new Node(25);
        root.left.right= new Node(27);
        root.right.left= new Node(35);
        root.right.right= new Node(37);

        int count_nodes= countNoOfNodes(root);
        int rootIndex=0;

        boolean isCBT=isComplete(root, rootIndex,count_nodes);
        System.out.println(isCBT);
    }

    private static int countNoOfNodes(Node root) {
        if(root==null)
            return 0;
        return (1+countNoOfNodes(root.left)+countNoOfNodes(root.right));
    }

    private static boolean isComplete(Node root, int currentIndex, int countNodes) {
        if(root==null)
            return true;
        
        if(currentIndex>=countNodes)
            return false;
        return isComplete(root.left,currentIndex*2+1,countNodes) && 
                isComplete(root.right, currentIndex*2+2,countNodes);
    }
}