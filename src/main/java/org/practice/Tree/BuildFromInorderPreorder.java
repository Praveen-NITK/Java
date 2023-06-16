package org.practice.Tree;

//https://labuladong.gitbook.io/algo-en/ii.-data-structure/framework-and-thoughts-about-learning-data-structure-and-algorithm
public class BuildFromInorderPreorder{
    static class Node{
        char data;
        Node left,right;
        public Node(char d){
            data=d;
            left=right=null;
        }
    }

    static int preIndex = 0; 

    public static void main(String[] args) {
        char []inOrder=new char[]{'D','B','E','A','F','C'};
        char []preOrder=new char[]{'A','B','D','E','C','F'};
        Node root=constructTree(inOrder, 0,inOrder.length-1,preOrder,0,preOrder.length-1);
        System.out.println("Inorder of constructed tree is ");
        printInorder(root);
    }

    private static void printInorder(Node root) {
        if(root==null)
            return;
        printInorder(root.left);
        System.out.print(" "+root.data);
        printInorder(root.right);
    }

    private static Node constructTree(char[] inOrder, int inStart, int inEnd,char[] preOrder, int preStart, int preEnd){
        if(inStart>inEnd || preStart>preEnd)
            return null;
        Node root=new Node(preOrder[preStart]);
        int inRoot=getPosition(inOrder, root.data, inStart,inEnd);
        int numsLeft=inRoot-inStart;
        root.left=constructTree(inOrder, inStart,inRoot-1,preOrder,preStart+1,preStart+numsLeft);
        root.right=constructTree(inOrder, inRoot+1,inEnd,preOrder,preStart+numsLeft+1,preEnd);
        return root;
    }

    private static int getPosition(char[] inOrder, char key, int start, int end) {
        int i;
        for (i = start; i <= end; i++) {
            if(inOrder[i]==key)
                return i;
        }
        return i;
    }
}
