package LinkedLists;

import LinkedLists.CreateLL.Node;

public class ReverseLL{
    public static void main(String[] args) {
        //Node head= reverseLL(LinkedLists.CreateLL.createLL());        
        //LinkedLists.CreateLL.printLL(head);       

        Node reversed=recursiveReverse(LinkedLists.CreateLL.createLL(),null);
        LinkedLists.CreateLL.printLL(reversed);
    }

    private static Node reverseLL(Node head) {
        Node prev=null;
        Node current=head;
        Node next=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        return head;
    }

    static Node head=null;    

    public static Node recursiveReverse(Node node, Node prevp){
        
        if(node.next==null){
            head=node;
            node.next=prevp;
            return head;
        }

        Node nextp=node.next;
        node.next=prevp;
        recursiveReverse(nextp,node);
        return head;
    }
}