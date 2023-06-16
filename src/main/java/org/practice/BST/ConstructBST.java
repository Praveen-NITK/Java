package org.practice.BST;
//https://www.geeksforgeeks.org/binary-search-tree-data-structure/
class ConstructBST{
    class Node{
        int data;
        Node left, right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    Node root;
    ConstructBST(){
        root=null;
    }

    void insert(int data){
        root= insertData(root,data);
    }

    Node insertData(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            root.left= insertData(root.left, data);
        }
        else if(data>root.data){
            root.right= insertData(root.right, data);
        }
        return root;
    } 

    public static void main(String[] args) {
        ConstructBST cBST=new ConstructBST();
        cBST.insert(5);
        cBST.insert(3);
        cBST.insert(2);
        cBST.insert(4);
        cBST.insert(7);
        cBST.insert(6);
        cBST.insert(8);

        inorder(cBST.root);
    }

    static void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }
}
