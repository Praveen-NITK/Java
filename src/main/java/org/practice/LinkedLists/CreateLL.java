package org.practice.LinkedLists;
public class CreateLL{
    static class Node{
        int data;
        Node next;
        public Node(int d){
            data=d;
            next=null;
        }
    }
    public static void main(String[] args) {
        Node head=createLL();
        printLL(head);
        
    }

    protected static void printLL(Node head) {
        while(head!=null){
            System.out.print(head.data+" --> ");
            head=head.next;
        }
    }

    protected static Node createLL() {
        Node head= new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next=new Node(5);

        return head;
    }
}
