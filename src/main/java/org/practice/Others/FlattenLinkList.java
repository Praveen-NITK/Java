package org.practice.Others;
//import sun.awt.image.ImageWatched.Link;

public class FlattenLinkList{

    Node head;
    static class Node{
        int data;
        Node right;
        Node down;

        public Node(int d){
            data=d;
            right=null;
            down=null;
        }
    }

    Node push(Node head, int data){
        Node newNode= new Node(data);
        newNode.down=head;
        head=newNode;
        return head;
    }

    public static void main(String[] args) {
        FlattenLinkList root=new FlattenLinkList();

        /* Let us create the following linked list 
            5 -> 10 -> 19 -> 28 
            |    |     |     | 
            V    V     V     V 
            7    20    22    35 
            |          |     | 
            V          V     V 
            8          50    40 
            |                | 
            V                V 
            30               45 
        */

        root.head=root.push(root.head, 30);
        root.head=root.push(root.head, 8);
        root.head=root.push(root.head, 7);
        root.head=root.push(root.head, 5);

        root.head.right=root.push(root.head.right, 20);
        root.head.right=root.push(root.head.right, 10);

        root.head.right.right=root.push(root.head.right.right, 50);
        root.head.right.right=root.push(root.head.right.right, 22);
        root.head.right.right=root.push(root.head.right.right, 19);

        root.head.right.right.right=root.push(root.head.right.right.right, 45);
        root.head.right.right.right=root.push(root.head.right.right.right, 40);
        root.head.right.right.right=root.push(root.head.right.right.right, 35);
        root.head.right.right.right=root.push(root.head.right.right.right, 28);


    }

    
}
