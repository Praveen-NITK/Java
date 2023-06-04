//https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
package MustDo.Google;
public class BTSubtreeOfOther
{
    static class Node{
        int data;
        Node left, right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        Node tree1= new Node(10);
        tree1.left= new Node(4);
        tree1.right= new Node(6);
        tree1.left.right=new Node(30);

        Node tree2= new Node(7);
        tree2.right=new Node(13);
        tree2.right.right= new Node(3);        
        tree2.left=new Node(10);
        tree2.left.left= new Node(4);
        tree2.left.right= new Node(6);
        tree2.left.left.right=new Node(30);

        boolean isSubtree= checkIfSubtree(tree2, tree1);
        System.out.println("tree1 is subtree of tree1 : "+isSubtree);

    }

    private static boolean checkIfSubtree(Node main, Node sub) {
        if(sub==null )
            return true;
        if(main==null)
            return false;
        if(isIdentical(main,sub))
            return true;
        
        return checkIfSubtree(main.left, sub) || checkIfSubtree(main.right, sub);
    }

    private static boolean isIdentical(Node main, Node sub) {
        if(main==null && sub ==null)
            return true;
        if(main==null || sub ==null)
            return false;
        if(main.data!=sub.data)
            return false;
        return isIdentical(main.left, sub.left) && isIdentical(main.right, sub.right);
    }
}
