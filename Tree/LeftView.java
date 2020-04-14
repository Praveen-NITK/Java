package Tree;
public class LeftView{
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
        root.right.right.left=new Node(8);
        
        //Printing from top to down
        getLeftView(root);
    }
    static int depth=0;

    private static void getLeftView(Node root) {
        int currnodeHeight=getHeight(root);
        if(root==null){
            return;
        }
        if(currnodeHeight>depth){
            System.out.println(root.data);
            depth=currnodeHeight;
        }
        getLeftView(root.left);
        getLeftView(root.left);
    }

    private static int getHeight(Node root) {
        if(root==null)
            return 0;
        int lefth= getHeight(root.left);
        int righth= getHeight(root.right);
        if(lefth>righth)
            return lefth+1;
        return righth+1;
    }
}