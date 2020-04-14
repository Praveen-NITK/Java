//https://www.geeksforgeeks.org/clockwise-spiral-traversal-of-binary-tree-set-2/
package Tree;
public class SpiralLevelOrder{
    static class Node{
        int data;
        Node left,right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        root.left.left.left=new Node(8);
        root.left.left.right=new Node(9);

        int height=getHeight(root);

        boolean traverseLeftToRight=true;
        int i=1;
        int j=height;
        while(i<=j){
            if(traverseLeftToRight){
                leftToRight(root,i);
                i++;
                traverseLeftToRight=!traverseLeftToRight;
            }
            else{
                rightToLeft(root,j);
                j--;
                traverseLeftToRight=!traverseLeftToRight;
            }            
        }        
    }

    private static void rightToLeft(Node root, int j) {
        if(root==null || j<=0)
            return;
        if(j==1)
            System.out.println(root.data);
        rightToLeft(root.right, j-1);
        rightToLeft(root.left, j-1);
    }

    private static void leftToRight(Node root, int i) {
        if(root==null || i<=0)
            return;
        if(i==1)
            System.out.println(root.data);
        leftToRight(root.left, i-1);
        leftToRight(root.right, i-1);
    }

    private static int getHeight(Node root) {
        if(root==null)
            return 0;
        int lheight=getHeight(root.left);
        int rheight= getHeight(root.right);
        if(lheight>rheight)
            return lheight+1;
        else
            return rheight+1;
    }    
}