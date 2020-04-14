package Tree;

//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
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
        int len=inOrder.length;
        Node root=buildTree(inOrder,preOrder,0,len-1);
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

    private static Node buildTree(char[] inOrder, char[] preOrder, int instart, int inend) {
        if(instart>inend)
            return null;       
        
        Node tnode=new Node(preOrder[preIndex++]);

        if(instart==inend)
            return tnode;

        int inIndex=getPosition(inOrder,tnode.data,instart,inend);
        //node.left=buildTree(Arrays.asList(inOrder).subList(0, indexInOrder).toArray(new Character[0]), Arrays.asList(preOrder).subList(1, preOrder.length+1).toArray(new Character[0]));
        //node.right=buildTree(Arrays.asList(inOrder).subList(indexInOrder+1,inOrder.length).toArray(new Character[0]), Arrays.asList(preOrder).subList(1, preOrder.length+1).toArray(new Character[0]));

        tnode.left=buildTree(inOrder, preOrder, instart, inIndex-1);
        tnode.right=buildTree(inOrder, preOrder, inIndex+1, inend);

        return tnode;
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