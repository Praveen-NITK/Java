package BST;

import java.util.Date;

//https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
class DeleteNodeBST{
    class Tree{
        int data;
        Tree left,right;
        Tree(int d){
            data=d;
            left=right=null;
        }
    }
    Tree root;

    DeleteNodeBST(){
        root=null;
    }

    void insert(int key){
        root=insertNode(root,key);
    }

    private Tree insertNode(Tree root, int key) {

        if(root==null){
            root=new Tree(key);
            return root;
        }
        if(key<root.data){
            root.left=insertNode(root.left, key);
        }
        else if(key>root.data){
            root.right=insertNode(root.right, key);
        }
        return root;
    }

    void deleteNode(int key) {
        root=deleteNodeFromBST(root,key);
    }

    private Tree deleteNodeFromBST(Tree root, int key) 
    {
        if(root==null){
            return root;
        }
        if(key<root.data){
            root.left=deleteNodeFromBST(root.left, key);
        }
        else if(key>root.data){
            root.right=deleteNodeFromBST(root.right, key);
        }
        //same as root
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            root.data=getMinimum(root.right);
            
            //for Optimisation comment below line and add part in getMin() while loop
            //root.right=deleteNodeFromBST(root.right,root.data);

            root.right=deleteNodeFromBST(root.right,root.data);
        }
        return root;
    }

    int getMinimum(Tree root)
    {
        int min=root.data;        
        while(root.left!=null){
            min=root.left.data;

            //for Optimisation uncomment
            // if(root.left.left==null){
            //     root.left=null;
            //     break;
            // }
            
            root=root.left;
        }
        return min;
    }
    public static void main(String[] args) {
        System.out.println(new Date());
        DeleteNodeBST dBst= new DeleteNodeBST();
        dBst.insert(30);
        dBst.insert(20);
        dBst.insert(40);
        dBst.insert(10);
        dBst.insert(25);
        dBst.insert(35);
        dBst.insert(45);
        dBst.insert(33);
        dBst.insert(37);       

        inorder(dBst.root);        
        dBst.deleteNode(330);
        System.out.println("Tree post deletion");
        inorder(dBst.root);
        System.out.println(new Date());
    }

    private static void inorder(Tree root) {
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}