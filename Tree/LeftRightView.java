package Tree;

import java.util.HashSet;

public class LeftRightView {
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

        System.out.println("left view: ");
        getLeftView(root, 0);
        System.out.println("right view: ");
        getRightView(root, 0);
    }


     static int maxLeftLevel=Integer.MIN_VALUE;
     static int maxRightLevel=Integer.MIN_VALUE;

     private static void getLeftView(Node root, int level) {
        if(root==null){
            return;
        }
        if(maxLeftLevel<level){
            System.out.println(root.data);
            maxLeftLevel=level;
        }
        getLeftView(root.left,level+1);
         getLeftView(root.right,level+1);

    }
    private static void getRightView(Node root, int level) {
        if(root==null){
            return;
        }
        if(maxRightLevel<level){
            System.out.println(root.data);
            maxRightLevel=level;
        }
        getRightView(root.right,level+1);
        getRightView(root.left,level+1);

    }

//    static HashSet<Integer> leftHeightSet= new HashSet<>();
//    static HashSet<Integer> rightHeightSet= new HashSet<>();
    //    private static void getLeftView(Node root, Node node) {
//        if(root==null){
//            return;
//        }
//        int currnodeHeight=getDepth(node, root.data,0);
//        if(!leftHeightSet.contains(currnodeHeight)){
//            System.out.println(root.data);
//            leftHeightSet.add(currnodeHeight);
//        }
//        getLeftView(root.left,node);
//        getLeftView(root.right,node);
//
//    }

//    private static void getRightView(Node root, Node node) {
//        if(root==null){
//            return;
//        }
//        int currnodeHeight=getDepth(node, root.data,0);
//        if(!rightHeightSet.contains(currnodeHeight)){
//            System.out.println(root.data);
//            rightHeightSet.add(currnodeHeight);
//        }
//        getRightView(root.right,node);
//        getRightView(root.left,node);
//
//    }

    private static int getDepth(Node root, int data, int level) {
        if(root==null)
            return 0;
        if(root.data==data)
            return level;

        int depth=getDepth(root.left, data, level + 1);
        if(depth!=0)
            return depth;
        depth=getDepth(root.right, data, level + 1);
        return depth;


    }

//    private static int getHeight(Node root) {
//        if(root==null)
//            return 0;
//        int lefth= getHeight(root.left);
//        int righth= getHeight(root.right);
//        if(lefth>righth)
//            return lefth+1;
//        return righth+1;
//    }


}