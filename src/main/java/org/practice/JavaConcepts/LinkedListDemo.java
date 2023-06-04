package JavaConcepts;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>();
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(5);
        ll.remove();
        System.out.println(ll.getLast());
        System.out.println(ll.getFirst());
    }

    /**
     * A round-robin scheduler could be implemented with a traditional linked list(singly link list), by
     * repeatedly performing the following steps on linked list L (see Figure 3.15):
     * 1. process p = L.removeFirst( )
     * 2. Give a time slice to process p
     * 3. L.addLast(p)
     *
     *
     * It is unnecessarily inefficient to repeatedly throw away a node from one
     * end of the list, only to create a new node for the same element when reinserting it,
     * not to mention the various updates that are performed to decrement and increment
     * the list’s size and to unlink and relink nodes
     *
     *
     */


}
