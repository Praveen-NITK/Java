//Find Lowest Comon Ancestor in BST
package BST;

public class CommonAncestor{
    static class Node{
        int data;
        Node left, right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }
    static Node root=null;
    public static void main(String[] args) {
        root= constructBst(root, 5);
        root= constructBst(root, 3);
        root= constructBst(root, 8);
        root= constructBst(root, 2);
        root= constructBst(root, 4);
        root= constructBst(root, 6);
        root= constructBst(root, 6);

        Node lca=findLowestCommonAncestor(root,3,7);
        System.out.println(lca.data);

    }

    private static Node findLowestCommonAncestor(Node root, int i, int j) {
        if(root==null)
            return null;
        if(i<root.data && j<root.data)
            return findLowestCommonAncestor(root.left, i, j);
        else if(i>root.data && j>root.data)
            return findLowestCommonAncestor(root.right, i, j);
        return root;
    }

    private static Node constructBst(Node root, int d) {
        if(root==null){
            return new Node(d);
        }
        if(d<root.data){
            root.left= constructBst(root.left,d);
        }
        else if(d>root.data){
            root.right= constructBst(root.right,d);
        }
        return root;
    }
}