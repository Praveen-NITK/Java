//https://www.geeksforgeeks.org/delete-every-kth-node-from-circular-linked-list/
//https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/ ==>for finding the survival position
package LinkedLists;
public class DeleteKthCircular{
    static class Node{
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }

    public static void main(String[] args) {
        Node head= new Node(5);
        head.next= new Node(10);
        head.next.next= new Node(15);
        head.next.next.next= new Node(20);
        head.next.next.next.next= new Node(25);
        head.next.next.next.next.next= new Node(30);
        head.next.next.next.next.next.next= new Node(35);
        head.next.next.next.next.next.next.next= new Node(40);
        head.next.next.next.next.next.next.next.next= head;

        //Delete node at kth position untill only one node is there.
        Node resultNode=deleteNode(head,3);
        //while (resultNode!=null) {
            System.out.println(resultNode.data);
            //resultNode=resultNode.next;
        //}
    }

    private static Node deleteNode(Node head, int pos) {
        Node iterator=head;
        while(true){
            if(head==null){
                return null;
            }
            //Only one node is there
            if(head.next==head)
                return head;

            for (int i = 1; i < pos; i++) {
                iterator=iterator.next;
            }

            //If 1st node to be deleted.
            if(iterator.next==head){
                head=head.next;
                iterator.next=head;
            }
            else{
                iterator.next=iterator.next.next;
            }
            
            //Only for keep on printing list post deletion
            Node temp=head;
            do{
                System.out.print(temp.data + "-->");
                temp=temp.next;
            }while(temp!=head);
            System.out.println();
        }
    }
}