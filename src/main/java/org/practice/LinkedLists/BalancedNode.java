//https://www.geeksforgeeks.org/find-the-balanced-node-in-a-linked-list/
//Left sum and right sum is equal
package LinkedLists;
public class BalancedNode{
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

        printBalancedNode(head);
    }

    private static void printBalancedNode(Node head) {
        if(head!=null){
            int sum=0;
            Node temp= head;
            while(temp!=null){
                sum+=temp.data;
                temp=temp.next;
            }

            temp=head;
            int LeftSum=0;
            while(temp!=null){                
                if((sum-temp.data)/2==LeftSum){
                    System.out.println(temp.data);
                    return;
                }
                LeftSum+=temp.data;
                temp=temp.next;
            }            
        }
        System.out.println(-1);
    }
}