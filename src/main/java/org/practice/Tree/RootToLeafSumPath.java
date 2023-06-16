package org.practice.Tree;
public class RootToLeafSumPath{
    static class Tree{
        int data;
        Tree left, right;
        Tree(int d){
            data=d;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        Tree root= new Tree(10);
        root.left=new Tree(12);
        root.right=new Tree(8);
        root.left.left= new Tree(6);
        root.left.right= new Tree(5);
        root.right.left= new Tree(7);
        root.right.right= new Tree(4);

        boolean result=isPathExistOfSumRecursive(27,root);
        System.out.println(result);

}

    private static boolean isPathExistOfSumRecursive(int sum, Tree root) {
        if(root==null){
            return (sum==0);
        }
        return isPathExistOfSumRecursive(sum-root.data, root.left) || 
                isPathExistOfSumRecursive(sum-root.data, root.right);
    }    
}
