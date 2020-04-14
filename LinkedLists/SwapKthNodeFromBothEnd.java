//https://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
package LinkedLists;
public class SwapKthNodeFromBothEnd{
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public static void main(String[] args) {
        Node head= new Node(2);
        head.next= new Node(13);
        head.next.next=new Node(7);
        head.next.next.next= new Node(12);
        head.next.next.next.next= new Node(22);

        swapKthNode(head,2);
    }

    private static void swapKthNode(Node head, int k) {
        int length=getSizeOflist(head);
        if(length<k)
            return;

        //traverse till k
        //maintain two pointers
    }

    private static int getSizeOflist(Node head) {
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}