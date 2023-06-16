package org.practice.LinkedLists;



public class ReverseLL{
    public static void main(String[] args) {
        CreateLL.Node head= reverseLL(CreateLL.createLL());
        CreateLL.printLL(head);

        CreateLL.Node reversed=recursiveReverse(CreateLL.createLL(),null);
        CreateLL.printLL(reversed);
    }

    private static CreateLL.Node reverseLL(CreateLL.Node head) {
        CreateLL.Node prev=null;

        while(head!=null){
            CreateLL.Node next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }

    static CreateLL.Node head=null;

    public static CreateLL.Node recursiveReverse(CreateLL.Node node, CreateLL.Node prevp){
        
        if(node.next==null){
            head=node;
            node.next=prevp;
            return head;
        }

        CreateLL.Node nextp=node.next;
        node.next=prevp;
        recursiveReverse(nextp,node);
        return head;
    }
}
