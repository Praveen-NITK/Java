package org.practice.Others;
// import com.sun.org.apache.xpath.internal.operations.Bool;
// import java.util.*;
// import java.lang.*;
// import java.io.*;

public class LinkedList{

    static class Node{
        int data;
        Node next;
        public Node(int d){
            data=d;
            next=null;
        }
    }

    static class ListNode{
        int data;
        ListNode right;
        ListNode down;
        
        public ListNode(int d){
            data=d;
            right=null;
            down=null;
        }
    }

    static int intArray[] = new int[51];
    //Arrays.fill(intArray,new Integer(0));
    //fill(intArray,new Integer(0));

    public static void main(String[] args) {
        Node node= new Node(5);
        node.next=new Node(10);
        node.next.next=new Node(15);
        node.next.next.next=new Node(20);
        node.next.next.next.next=new Node(25);
        node.next.next.next.next.next=new Node(30);
        node.next.next.next.next.next.next=new Node(35);
        node.next.next.next.next.next.next.next=new Node(40);
        node.next.next.next.next.next.next.next.next=new Node(45);
        //node.next.next.next.next.next.next.next.next.next=node.next.next.next;    //For loop


        Node node1= new Node(5);
        node1.next=new Node(10);
        node1.next.next=new Node(15);
         node1.next.next.next=new Node(20);
        // node1.next.next.next.next=new Node(25);
        // node1.next.next.next.next.next=new Node(30);

        // System.out.println("Traverse List");
        // printLinkList(node);
        
        // System.out.println("Reverse List");
        // //Node reverse=iterativeReverseLinkList(node);
        // Node reverse=recursiveReverse(node, null);
        // printLinkList(reverse);

        // System.out.println("Alternate List");
        // Node alternate=deleteAlternateNode(node);
        // printLinkList(alternate);

        // System.out.println("Alternate List with one Aux pointer");
        // deleteAlternateNodeOnePtr(node);
        // printLinkList(node);


        // System.out.println("Alternate nodes with zero Aux Pointer");
        // deleteAlternateNodeZeroPtr(node);
        // printLinkList(node);

        // System.out.println("Is Loop exist");
        // System.out.println(isLoopExist(node));

        // deleteNode(node, 25);
        // printLinkList(node);
        
        //System.out.println(isListEqual(node,node1));

        //printMiddleOfList(node1);

        //#region FlatterList
        /*
        Flattening a Linked List (https://www.geeksforgeeks.org/flattening-a-linked-list/)
        Given a linked list where every node represents a linked list and contains two pointers of its type:
        (i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
        (ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
        All linked lists are sorted. See the following example

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

        Write a function flatten() to flatten the lists into a single linked list. 
        The flattened linked list should also be sorted. For example, for the above input list, 
        output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
        */

        ListNode listNode= new ListNode(5);
        listNode.right=new ListNode(10);
        listNode.down=new ListNode(7);
        listNode.down.down=new ListNode(8);
        listNode.down.down.down=new ListNode(30);
        listNode.right.down=new ListNode(20);
        listNode.right.right=new ListNode(19);
        listNode.right.right.down=new ListNode(22);
        listNode.right.right.down.down=new ListNode(50);
        listNode.right.right.right=new ListNode(28);
        listNode.right.right.right.down=new ListNode(35);
        listNode.right.right.right.down.down=new ListNode(40);
        listNode.right.right.right.down.down.down=new ListNode(45);

        flatterList(listNode);
        printLinkList(printFlatterSortedList(intArray));

        //#endregion 

    }

    public static void printLinkList(Node node){
        
        //Print Reverse recursively
        // if(node==null){
        //     return;
        // }       
        // printLinkList(node.next);
        // System.out.println(node.data);

        
        //Print Link List forward
        while (node!=null){           
            System.out.print(node.data +" -> ");
            node=node.next;
        }
        System.out.print(" null ");
    }

    public static Node iterativeReverseLinkList(Node node){       
        Node prevp=null;
        Node current=node;
        Node nextp=null;
        while(current!=null){
            nextp=current.next;
            current.next=prevp; //Reversing step
            prevp=current;
            current=nextp;
        }
        node=prevp;
        return node;         
    }

    static Node head;
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

    public static Node deleteAlternateNode(Node node){
        Node ptr1=node;
        Node ptr2=node;
        while(ptr1.next!=null && ptr2.next!=null){
            ptr2=ptr1.next;
            ptr1.next=ptr2.next;
            ptr2.next=null;
            
            ptr1=ptr1.next;
            ptr2=ptr1;
        }
        return node;
    }

    public static void deleteAlternateNodeOnePtr(Node node){
        Node ptr1=node;
        while(ptr1!=null && ptr1.next!=null ){
            ptr1=ptr1.next.next;            
            node.next.next=null;
            node.next=ptr1;
            node=ptr1;
        }
    }

    public static void deleteAlternateNodeZeroPtr(Node node){
        while(node!=null && node.next!=null ){
            node.next=node.next.next;            
            node=node.next;
        }
    }

    public static boolean isLoopExist(Node node){
        Node ptr1=node;
        Node ptr2=node.next;
        while(ptr1!=null && (ptr2!=null && ptr2.next!=null)){
            if(ptr1==ptr2){
                //isLoop= true;
                return true;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next.next;
        }
        return false;
    }

    public static void deleteNode(Node node, int d){
        while(node!=null && node.next!=null){
            if (node.next.data==d){
                Node temp= node.next.next;
                node.next.next=null;
                node.next=temp;
            }
            node=node.next;
        }
    }

    public static boolean isListEqual(Node node1, Node node2){
        boolean isEqual=false;
        while(node1!=null && node2!=null){
            if(node1.data==node2.data){
                isEqual=true;                
            }
            else{
                isEqual=false;
            }
            node1=node1.next;
            node2=node2.next;
        }
        if((node1!=null && node2==null) || (node1==null && node2!=null)){
            isEqual=false;
        }
        return isEqual;
    }

    public static void printMiddleOfList(Node node){
        Node ptr=node;
        while(ptr!=null && ptr.next!=null){
            ptr=ptr.next.next;
            node=node.next;
        }
        if(ptr==null ||ptr.next==null){
            System.out.println(node.data);
        }
        
    }    
    
    public static void flatterList(ListNode listNode){
        if(listNode==null){
            return;
        }
        intArray[listNode.data]=listNode.data;
        flatterList(listNode.down);
        flatterList(listNode.right);
        
    }

    public static Node printFlatterSortedList(int arr[]){
        Node ret=new Node(0);
        head=ret;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                head.next=new Node(arr[i]);
                head=head.next;
                //System.out.println(arr[i]);
            }
        }
        return ret.next;
    }
}
