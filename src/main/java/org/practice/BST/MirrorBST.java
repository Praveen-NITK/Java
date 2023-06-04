package BST;

import java.util.Stack;

public class MirrorBST{
    static class Tree{
        int data;
        Tree left,right;
        Tree(int d){
            data=d;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        
        Tree tree1= new Tree(50);
        tree1.left=new Tree(30);
        tree1.left.left=new Tree(20);
        tree1.left.right= new Tree(40);
        tree1.left.right.right=new Tree(35);
        tree1.right=new Tree(70);
        tree1.right.right=new Tree(60);


        Tree tree2= new Tree(500);
        tree2.left=new Tree(300);
        tree2.left.left=new Tree(200);
        tree2.left.right= new Tree(400);
        tree2.left.right.right=new Tree(350);
        tree2.right=new Tree(700);
        tree2.right.right=new Tree(800);

        Tree tree3= new Tree(50);
        tree3.right=new Tree(30);
        tree3.right.right=new Tree(20);
        tree3.right.left= new Tree(40);
        tree3.right.left.left=new Tree(35);
        tree3.left=new Tree(70);
        tree3.left.left=new Tree(60);
        //tree3.left.right=new Tree(80);


        //boolean isMirror= isMirrorBSTs(tree1,tree3);
        //boolean isMirror= isMirrorData(tree1,tree3);
        boolean isMirror= isMirrorIterative(tree1,tree3);
        System.out.println(isMirror);
    }
    static boolean isNodeSame=true;
    private static boolean isMirrorBSTs(Tree tree1, Tree tree2) {
        if(tree1==null && tree2==null){
            isNodeSame=isNodeSame?true:false;
            return true;
        }
        if((tree1==null && tree2!=null) || (tree2==null && tree1!=null)){
            isNodeSame=false;
            return false;
        }
        isMirrorBSTs(tree1.left, tree2.right);
        isMirrorBSTs(tree1.right, tree2.left);
        
        return isNodeSame;
    }

    private static boolean isMirrorData(Tree tree1, Tree tree2) {
        if(tree1==null && tree2==null){
            return true;
        }
        if(tree1==null || tree2==null){
            return false;
        }
        return tree1.data==tree2.data && 
                            isMirrorData(tree1.left, tree2.right) && 
                            isMirrorData(tree1.right, tree2.left);
        
    }

    private static boolean isMirrorIterative(Tree tree1, Tree tree2){
        Stack<Tree> st1=new Stack<>();
        Stack<Tree> st2=new Stack<>();

        while(true){
            while(tree1!=null && tree2!=null){
                if(tree1.data!=tree2.data){
                    return false;
                }
                st1.push(tree1);
                st2.push(tree2);
                tree1=tree1.left;
                tree2=tree2.right;
            }
            if(!(tree1==null && tree2==null)){
                return false;
            }
            if(!st1.isEmpty() && !st2.isEmpty()){
                tree1=st1.peek();
                tree2=st2.peek();
                st1.pop();
                st2.pop();

                tree1=tree1.right;
                tree2=tree2.left;
            }
            else
                break;
        }

        return true;
    }

}