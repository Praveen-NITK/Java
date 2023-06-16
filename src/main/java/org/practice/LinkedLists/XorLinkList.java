//https://www.geeksforgeeks.org/xor-linked-list-a-memory-efficient-doubly-linked-list-set-1/
package org.practice.LinkedLists;
public class XorLinkList{
    static class Node{
        char data;
        Node nextp;
        Node(char d){
            data=d;
            nextp=null;
        }
    }

    public static void main(String[] args) {
        Node head=new Node('A');
        //head.nextp=XoR(0,new Node('B'));  
        //Can't be implemented in Java      
    }

    // private static int XoR(Node prevNode, Node nextNode) {
    //     return prevNode.hashCode()^nextNode.hashCode();
    // }
}