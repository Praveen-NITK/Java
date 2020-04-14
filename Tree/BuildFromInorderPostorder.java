package Tree;

public class BuildFromInorderPostorder{
    static class Node{
        char data;
        Node left,right;
        public Node(char d){
            data=d;
            left=right=null;
        }
    }

    static int postIndex;

    public static void main(String[] args) {
        char[] postOrder=new char[]{'D', 'E', 'B', 'F', 'C', 'A'};
        char[] inOrder = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};

        int len=inOrder.length;
        postIndex=len-1;

        Node root= buildTree(postOrder,inOrder, 0, len-1);
        System.out.println("Inorder of constructed tree is: ");
        printInOrderTraversal(root);
    }

    

    private static Node buildTree(char[] postOrder, char[] inOrder, int inStart, int inEnd) {
        if(inStart>inEnd)
            return null;
        
        int inIndex=getInOderIndex(inOrder,postOrder[postIndex--],inStart,inEnd);
        Node tnode=new Node(inOrder[inIndex]);

        if(inStart==inEnd)
            return tnode;

        tnode.right=buildTree(postOrder, inOrder, inIndex+1, inEnd);
        tnode.left=buildTree(postOrder, inOrder, inStart, inIndex-1);
        return tnode;
    }

    private static int getInOderIndex(char[] inOrder, char key, int start, int end) {
        int i;
        for (i = start; i <= end; i++) {
            if(inOrder[i]==key)
                return i;
        }
        return i;
    }

    private static void printInOrderTraversal(Node root) {
        if(root==null)
            return;
        printInOrderTraversal(root.left);
        System.out.print(" "+root.data);
        printInOrderTraversal(root.right);
    }
}