package Tree;

public class PathMaxSum {
    static class Node{
        int data;
        Node left,right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node root=constructTree();
        int maxSum=findMaxPathSum(root);
        System.out.println(maxSum);
    }

    static int ans=Integer.MIN_VALUE;

    private static int findMaxPathSum(Node root) {
        if(root==null) return 0;
        int leftSum=findMaxPathSum(root.left);
        int rightSum=findMaxPathSum(root.right);
        ans = Math.max(ans,leftSum+rightSum+root.data);

        return Math.max(leftSum,rightSum)+root.data;
    }

    private static Node constructTree() {
        Node root= new Node(10);
        root.left=new Node(11);
        root.right=new Node(12);
        root.left.left=new Node(13);
        root.left.left.left=new Node(6);
        root.left.right=new Node(14);
        root.right.left=new Node(15);
        root.right.right=new Node(16);
        return root;
    }

}
