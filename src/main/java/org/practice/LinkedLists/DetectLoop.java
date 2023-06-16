package org.practice.LinkedLists;

import java.util.HashSet;
import java.util.List;

// Java program to detect loop in a linked list 
class DetectLoop { 
	class Node { 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
    }
	Node head;
	Node end;

	/* Inserts a new Node at front of the list. */
	public void insertAtFront(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head;
		head = new_node; 
	} 

	/* Inserts a new Node at end of the list. */
	public void insertAtLast(int new_data) 
	{ 
		end=head;		
		Node new_node = new Node(new_data);
		if(head==null){
			head=new_node;
			end=head;
			return;
		}
		while(end.next!=null)
		{
			end=end.next;
		}		
		end.next = new_node;
		end = new_node; 
		
		
	}

	int detectLoop() 
	{ 
		Node slow_p = head, fast_p = head; 
		while (slow_p != null && fast_p != null && fast_p.next != null) { 
			slow_p = slow_p.next; 
			fast_p = fast_p.next.next; 
			if (slow_p == fast_p) { 
				System.out.println("Found loop"); 
				return 1; 
			} 
		} 
		return 0; 
    } 
    
    boolean detectLoop(Node h) 
    { 
        HashSet<Node> s = new HashSet<Node>(); 
        while (h != null) { 
            if (s.contains(h)) 
                return true; 
            s.add(h);  
            h = h.next; 
        } 
  
        return false; 
	} 
	
	public static void traverseLL(Node node){
		while(node!=null){
			System.out.print(node.data+" --> ");
			node=node.next;
		}
	}

	public static void main(String args[]) 
	{ 
		DetectLoop llist = new DetectLoop(); 

		llist.insertAtFront(20); 
		llist.insertAtFront(4); 
		llist.insertAtFront(15); 
		llist.insertAtFront(10); 

		llist.insertAtLast(7);
		llist.insertAtLast(8);
		llist.insertAtLast(9);
		llist.insertAtLast(10);

		/*Create loop for testing */
		llist.end.next = llist.head;

        //Using two pointers
        //llist.detectLoop();
        
        //Using Hash
		//boolean b=llist.detectLoop(llist.head);

		//Delete every kth noode from head... 2nd ... 4th ... 6th.. etc
		removeNodeAtKthPosition(llist.head, 2);
		
		traverseLL(llist.head);
	}

	private static void removeNodeAtKthPosition(Node head2, int i) {
		while(head2!=null){
			
		}
	}
} 
